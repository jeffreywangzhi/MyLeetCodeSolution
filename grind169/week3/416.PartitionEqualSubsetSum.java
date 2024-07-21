class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for ( int i = 0; i < nums.length; i++ ) {
            sum += nums[i];
        }
        if ( sum % 2 == 1 ) return false;
        int target = sum / 2;
        boolean[] dp = new boolean[target+1];
        Arrays.fill(dp,false);
        dp[0] = true;
        for ( int num : nums ) {
            for ( int i = target; i >= num; i-- ) {
                dp[i] = dp[i] || dp[i-num];
            }
        }
        return dp[target];
    }
}