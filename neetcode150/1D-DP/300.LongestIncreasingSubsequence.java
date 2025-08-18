class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        int res = 1;
        for ( int i = dp.length-1; i >= 0; i-- ) {
            int curMax = 1;
            for ( int j = i+1; j < dp.length; j++ ) {
                if ( nums[i] < nums[j] ) curMax = Math.max(curMax,1+dp[j]);
            }
            dp[i] = curMax;
            res = Math.max(res,curMax);
        }
        return res;
    }
}