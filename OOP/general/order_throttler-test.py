"""
SANTÉ ENGINEERING INTERVIEW: CODING ARCHETYPE B
Problem: In-Memory Order Throttling (Sliding Time Windows)

CONTEXT:
Santé's omnichannel POS terminal receives a continuous stream of incoming online 
delivery orders from webhooks (Uber Eats, DoorDash, Shopify). During busy holiday 
hours, the system needs to monitor request volume to throttle heavy syncing or 
alert staff of sudden order spikes.

YOUR TASK:
Implement the `OrderThrottler` class to track the volume of incoming orders 
over a rolling 15-minute window (900 seconds).

REQUIREMENTS:
1. add_order(timestamp: int, order_id: str) -> None
   Called every time a new order hits the webhook. `timestamp` is given in 
   seconds and is guaranteed to be monotonic (strictly increasing or equal).
2. get_recent_order_count(timestamp: int) -> int
   Returns the total number of orders received in the strictly inclusive 15-minute 
   window: [timestamp - 900, timestamp].
3. Constraints: The physical POS terminal has limited RAM. Your class must 
   clean up expired orders so memory does not grow indefinitely over a 24-hour shift.
"""

from collections import deque

class OrderThrottler:
    def __init__(self):
        self.q = deque()

    def add_order(self, timestamp: int, order_id: str) -> None:
        self.q.append((timestamp,order_id))

    def get_recent_order_count(self, timestamp: int) -> int:
        while self.q and timestamp-self.q[0][0] > 900: self.q.popleft()
        return len(self.q)


# =====================================================================
# TEST RUNNER
# =====================================================================
def run_tests():
    throttler = OrderThrottler()

    # Test 1: Empty initial state
    assert throttler.get_recent_order_count(0) == 0, "Test 1 Failed: Should be 0"

    # Test 2: Add initial burst of orders (Timestamps in seconds)
    throttler.add_order(100, "ORDER_001")
    throttler.add_order(105, "ORDER_002")
    throttler.add_order(110, "ORDER_003")
    
    assert throttler.get_recent_order_count(115) == 3, "Test 2 Failed: Expected 3"

    # Test 3: Edge of the 15-minute window (900 seconds)
    # Order 001 at t=100 expires at t=1001. 
    # At t=1000, t-900 = 100. So ORDER_001 is exactly on the boundary and should be counted.
    assert throttler.get_recent_order_count(1000) == 3, "Test 3 Failed: Boundary inclusion expected 3"

    # Test 4: Sliding the window past old orders
    # At t=1001, t-900 = 101. ORDER_001 (t=100) is now expired.
    throttler.add_order(1005, "ORDER_004")
    assert throttler.get_recent_order_count(1005) == 3, "Test 4 Failed: Expected 3 (002, 003, 004)"

    # Test 5: Massive time jump (Terminal goes offline, reconnects hours later)
    # At t=10000, all previous orders should be expired and wiped from memory.
    throttler.add_order(10000, "ORDER_005")
    assert throttler.get_recent_order_count(10000) == 1, "Test 5 Failed: Expected 1"

    print("✅ All order throttler tests passed! Memory is clean.")

if __name__ == "__main__":
    run_tests()