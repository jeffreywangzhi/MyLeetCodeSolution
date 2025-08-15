class Solution {
    public int rob(int[] nums) {
        int[] res = new int[nums.length+2];
        res[2] = nums[0];
        for ( int i = 1; i < nums.length; i++ ) res[i+2] = Math.max(Math.max(res[i-1]+nums[i],res[i]+nums[i]),res[i+1]);
        return res[res.length-1];
    }
}