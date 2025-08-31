class Solution {
    public int jump(int[] nums) {
        int cur = 0, pre = 0, res = 0, i = 0;
        while ( cur < nums.length-1 ) {
            res++;
            pre = cur;
            for ( ; i <= pre; i++ ) {
                cur = Math.max(cur,i+nums[i]);
            }
        }
        return res;
    }
}