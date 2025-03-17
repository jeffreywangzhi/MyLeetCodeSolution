class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[] dp = new int[n];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[src] = 0;
        for ( int i = 0; i <= k; i++ ) {
            int[] tmp = Arrays.copyOf(dp,dp.length);
            for ( int[] flight : flights ) {
                int u = flight[0];
                int v = flight[1];
                int c = flight[2];
                if ( dp[u] < Integer.MAX_VALUE ) tmp[v] = Math.min(tmp[v],dp[u]+c);
            }
            dp = tmp;
        }
        return dp[dst] < Integer.MAX_VALUE ? dp[dst] : -1;
    }
}