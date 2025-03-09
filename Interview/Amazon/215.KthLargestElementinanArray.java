class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>((a,b)->b-a);
        for ( int num : nums ) queue.offer(num);
        int res = 0;
        for ( int i = 0; i < k; i++ ) res = queue.poll();
        return res;
    }
}