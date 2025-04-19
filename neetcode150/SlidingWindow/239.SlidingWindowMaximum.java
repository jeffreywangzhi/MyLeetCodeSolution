class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> deque = new LinkedList<>();
        List<Integer> list = new ArrayList<>();
        for ( int i = 0; i < nums.length; i++ ) {
            while ( (!deque.isEmpty() && (nums[deque.peekLast()]) < nums[i]) ) deque.pollLast();
            deque.offerLast(i);
            if ( i >= k-1 ) {
                list.add(nums[deque.peekFirst()]);
            }
            if ( (i - deque.peekFirst()) == k-1 ) deque.pollFirst();
        }
        int[] res = new int[list.size()];
        for ( int i = 0; i < res.length; i++ ) res[i] = list.get(i);
        return res;
    }
}