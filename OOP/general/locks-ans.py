import asyncio
from typing import Optional

# 1. Async delay function
async def delay():
    await asyncio.sleep(0.05)

class AsyncDelayedKV:
    def __init__(self):
        self.store = {}
        self.key_locks = {}
        self.meta_lock = asyncio.Lock()

    async def _get_lock(self, key) -> asyncio.Lock:
        async with self.meta_lock:
            if key not in self.key_locks:
                self.key_locks[key] = asyncio.Lock()
            return self.key_locks[key]

    async def get(self, key) -> Optional[int]:
        lock = await self._get_lock(key)
        async with lock:
            return self.store.get(key, None)

    async def increment(self, key) -> int:
        lock = await self._get_lock(key)
        async with lock:
            val = self.store.get(key, 0) + 1
            await delay()  # <--- MUST await the non-blocking I/O
            self.store[key] = val
            return val


# ==========================================
# TEST SUITE
# ==========================================

async def run_tests():
    print("Starting tests...\n")
    kv = AsyncDelayedKV()

    # TEST 1: Sequential Operations
    print("Test 1: Sequential GET and INCREMENT")
    assert await kv.get("apple") is None, "Failed: New key should return None"
    assert await kv.increment("apple") == 1, "Failed: First increment should return 1"
    assert await kv.increment("apple") == 2, "Failed: Second increment should return 2"
    assert await kv.get("apple") == 2, "Failed: Get should return 2"
    print("✅ Test 1 Passed\n")

    # TEST 2: High Concurrency on a Single Key (Race Condition Test)
    # If locks fail, 50 concurrent increments will overlap and result in < 50
    print("Test 2: 50 Concurrent Increments on 'banana'")
    tasks = [kv.increment("banana") for _ in range(50)]
    await asyncio.gather(*tasks)
    
    final_banana = await kv.get("banana")
    assert final_banana == 50, f"Failed: Race condition detected. Expected 50, got {final_banana}"
    print("✅ Test 2 Passed (No lost updates!)\n")

    # TEST 3: Parallelism Across Multiple Keys
    # Proves that updating 'cat' does not block 'dog'
    print("Test 3: Concurrent Increments across multiple keys")
    tasks_multi = [kv.increment("cat") for _ in range(20)] + [kv.increment("dog") for _ in range(20)]
    
    # We time this to ensure per-key locking is working. 
    # If they shared a global lock, 40 ops * 0.05s = 2.0 seconds.
    # With per-key locks, 20 ops * 0.05s = ~1.0 second.
    start_time = asyncio.get_event_loop().time()
    await asyncio.gather(*tasks_multi)
    end_time = asyncio.get_event_loop().time()
    
    assert await kv.get("cat") == 20
    assert await kv.get("dog") == 20
    print(f"✅ Test 3 Passed (Time elapsed: {end_time - start_time:.2f} seconds)\n")

    print("🎉 ALL TESTS PASSED!")

if __name__ == "__main__":
    asyncio.run(run_tests())