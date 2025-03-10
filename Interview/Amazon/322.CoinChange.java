class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        Arrays.fill(dp,Integer.MAX_VALUE-1);
        dp[0] = 0;
        for ( int i = 1; i < dp.length; i++ ) {
            for ( int coin : coins ) {
                int cur = i-coin;
                if ( cur < 0 ) continue;
                dp[i] = Math.min(dp[i],dp[cur]+1);
            }
        }
        return dp[amount] == Integer.MAX_VALUE-1 ? -1 : dp[amount];
    }
}