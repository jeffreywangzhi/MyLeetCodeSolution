import java.util.*;

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k == 0) {
            return new int[0];
        }
        Deque<Integer> deque = new LinkedList<>();
        List<Integer> result = new ArrayList<>();
        for ( int i = 0; i < nums.length; i++ ) {
            if ( !deque.isEmpty() && deque.peekFirst() < i-k+1 ) deque.pollFirst();
            while ( !deque.isEmpty() && nums[deque.peekLast()] < nums[i] ) deque.pollLast();
            deque.offerLast(i);
            if ( i >= k-1 ) result.add(nums[deque.peekFirst()]);
        }
        int[] res = new int[result.size()];
        for ( int i = 0; i < res.length; i++ ) res[i] = result.get(i);
        return res;
    }
}
