class Solution {
    public int maxCoins(int[] nums) {
        int[] newNums = new int[nums.length+2];
        newNums[0] = newNums[newNums.length-1] = 1;
        for ( int i = 0; i < nums.length; i++ ) newNums[i+1] = nums[i];
        int[][] dp = new int[newNums.length][newNums.length];
        for ( int i = 1; i < dp.length; i++ ) {
            for ( int j = 1; j < dp[0].length; j++ ) dp[i][j] = -1;
        }
        return dfs(newNums,1,newNums.length-2,dp);
    }
    public int dfs(int[] newNums, int l, int r, int[][] dp) {
        if ( l > r ) return 0;
        if ( dp[l][r] != -1 ) return dp[l][r];
        dp[l][r] = 0;
        for ( int i = l; i <= r; i++ ) {
            int cur = newNums[i]*newNums[l-1]*newNums[r+1];
            cur += dfs(newNums,l,i-1,dp)+dfs(newNums,i+1,r,dp);
            dp[l][r] = Math.max(dp[l][r],cur);
        }
        return dp[l][r];
    }
}