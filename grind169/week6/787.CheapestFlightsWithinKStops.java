class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[] dp = new int[n];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[src] = 0;
        for ( int i = 0; i <= k; i++ ) {
            int[] temp = Arrays.copyOf(dp,dp.length);
            for ( int[] arr : flights ) {
                int u = arr[0];
                int v = arr[1];
                int c = arr[2];
                if ( dp[u] < Integer.MAX_VALUE ) {
                    temp[v] = Math.min(temp[v],dp[u]+c);
                }
            }
            dp = temp;
        }
        return dp[dst] < Integer.MAX_VALUE ? dp[dst] : -1;
    }
}