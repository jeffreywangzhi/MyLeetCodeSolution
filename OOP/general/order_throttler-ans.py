"""
SANTÉ ENGINEERING INTERVIEW: REFERENCE SOLUTION
Problem: In-Memory Order Throttling (Sliding Time Windows)
"""

from collections import deque

class OrderThrottler:
    def __init__(self):
        # deque allows O(1) appends on the right and O(1) pops from the left
        self.queue = deque()
        self.window_size = 900  # 15 minutes in seconds

    def add_order(self, timestamp: int, order_id: str) -> None:
        # Store as a tuple. We primarily need the timestamp for eviction logic,
        # but storing the ID allows future extensibility (e.g., returning order batches).
        self.queue.append((timestamp, order_id))

    def get_recent_order_count(self, timestamp: int) -> int:
        # Defensive check: ensure queue is not empty before checking index 0
        # Evict all orders where the recorded timestamp is strictly less than the boundary
        boundary = timestamp - self.window_size
        
        while self.queue and self.queue[0][0] < boundary:
            self.queue.popleft()
            
        return len(self.queue)


# =====================================================================
# TEST RUNNER
# =====================================================================
def run_tests():
    throttler = OrderThrottler()

    assert throttler.get_recent_order_count(0) == 0, "Test 1 Failed"

    throttler.add_order(100, "ORDER_001")
    throttler.add_order(105, "ORDER_002")
    throttler.add_order(110, "ORDER_003")
    assert throttler.get_recent_order_count(115) == 3, "Test 2 Failed"

    assert throttler.get_recent_order_count(1000) == 3, "Test 3 Failed"

    throttler.add_order(1005, "ORDER_004")
    assert throttler.get_recent_order_count(1005) == 3, "Test 4 Failed"

    throttler.add_order(10000, "ORDER_005")
    assert throttler.get_recent_order_count(10000) == 1, "Test 5 Failed"

    print("✅ All order throttler tests passed! Memory is clean.")

if __name__ == "__main__":
    run_tests()