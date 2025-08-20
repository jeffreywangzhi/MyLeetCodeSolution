class Solution {
    public int change(int amount, int[] coins) {
        int[][] dp = new int[amount+1][coins.length];
        Arrays.fill(dp[0],1);
        for ( int i = 1; i <= amount; i++ ) {
            for ( int j = 0; j < coins.length; j++ ) {
                if ( i-coins[j] < 0 ) dp[i][j] = ( j == 0 ? 0 : dp[i][j-1] );
                else dp[i][j] = dp[i-coins[j]][j] + ( j == 0 ? 0 : dp[i][j-1] );
            }
        }
        return dp[amount][coins.length-1];
    }
}