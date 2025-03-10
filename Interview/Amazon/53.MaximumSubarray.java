class Solution {
    public int maxSubArray(int[] nums) {
        int cur = nums[0], res = nums[0];
        for ( int i = 1; i < nums.length; i++ ) {
            cur = Math.max(nums[i],cur+nums[i]);
            res = Math.max(res,cur);
        }
        return res;
    }
}