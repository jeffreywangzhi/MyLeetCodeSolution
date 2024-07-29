class Solution {
    public int rob(int[] nums) {
        int[] dp = new int[nums.length+2];
        for ( int i = 0; i < dp.length; i++ ) {
            if ( i < 2 ) dp[i] = 0;
            else dp[i] = Math.max(dp[i-2]+nums[i-2],dp[i-1]);
        }
        return dp[nums.length+1];
    }
}