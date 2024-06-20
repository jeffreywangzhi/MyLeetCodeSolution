class Solution {
    public int numTrees(int n) {
        int[] dp = new int[n+1];
        dp[0] = 1; dp[1] = 1;
        for ( int i = 2; i <= n; i++ ) {
            for ( int j = 0, k = i-1; k >= 0; j++, k-- ) {
                dp[i] += dp[j] * dp[k];
            }
        }
        return dp[n];
    }
}