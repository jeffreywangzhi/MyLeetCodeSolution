class Solution {
    public int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE, cur = 0;
        for ( int num : nums ) {
            cur = Math.max(num,cur+num);
            max = Math.max(max,cur);
        }
        return max;
    }
}