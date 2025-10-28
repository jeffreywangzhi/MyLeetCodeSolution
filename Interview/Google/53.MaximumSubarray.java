class Solution {
    public int maxSubArray(int[] nums) {
        int res = Integer.MIN_VALUE, cur = 0;
        for ( int n : nums ) {
            cur = Math.max(cur+n,n);
            res = Math.max(res,cur);
        }
        return res;
    }
}