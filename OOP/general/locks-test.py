"""
INTERVIEW PROMPT:
1. You are provided with an async delay function `delay()` simulating a 50ms slow database write.
2. Implement an in-memory Key-Value store class with two asynchronous methods: `get(key)` and `increment(key)`.
3. `get(key)`: Return None if the key does not exist, otherwise return the integer value.
4. `increment(key)`: Increment the value by 1 if it exists, or initialize to 1 if it does not. The actual writing of the value must await the `delay()` function.
5. Build the necessary locks to prevent race conditions when multiple concurrent requests attempt to increment the same key.
6. System throughput matters: an increment on key "A" should NOT block an increment on key "B".
"""

import asyncio
from typing import Optional

async def delay():
    """Simulated 50ms I/O delay."""
    await asyncio.sleep(0.05)


class AsyncDelayedKV:

    def __init__(self):
        self.dict = {}
        self.lock = {}
        self.meta_lock = asyncio.Lock()

    async def _get_lock(self, key: str) -> asyncio.Lock:
        async with self.meta_lock:
            if key not in self.lock:
                self.lock[key] = asyncio.Lock()
        return self.lock[key]


    async def get(self, key: str) -> Optional[int]:
        lock = await(self._get_lock(key))

        async with lock:
            if key not in self.dict:
                return None
            return self.dict[key]


    async def increment(self, key: str) -> int:
        lock = await(self._get_lock(key))

        async with lock:
            val = self.dict.get(key,0)+1
            await delay()
            self.dict[key] = val
            return val




# ==============================================================================
# DO NOT MODIFY BELOW - TEST RUNNER
# ==============================================================================

async def main():
    kv = AsyncDelayedKV()
    
    print("Testing sequential operations...")
    val = await kv.get("A")
    if val is not None:
        print(f"❌ Expected None, got {val}")
        return
        
    await kv.increment("A")
    await kv.increment("A")
    if await kv.get("A") != 2:
        print(f"❌ Expected 2, got {await kv.get('A')}")
        return
        
    print("Testing concurrency and race conditions (50 ops on key 'B')...")
    await asyncio.gather(*(kv.increment("B") for _ in range(50)))
    
    if await kv.get("B") != 50:
        print(f"❌ Race condition detected! Expected 50, got {await kv.get('B')}")
        return
        
    print("✅ All tests passed. Your locks are working perfectly.")

if __name__ == "__main__":
    asyncio.run(main())