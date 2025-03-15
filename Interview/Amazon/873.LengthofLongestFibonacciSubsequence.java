class Solution {
    public int lenLongestFibSubseq(int[] arr) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int[][] dp = new int[arr.length][arr.length];
        int res = 0;
        for ( int i = 0; i < arr.length; i++ ) {
            map.put(arr[i],i);
            for ( int j = 0; j < i; j++ ) {
                int k = map.getOrDefault(arr[i]-arr[j],-1);
                if ( k < 0 || k >= j) dp[j][i] = 2;
                else {
                    dp[j][i] = dp[k][j]+1;
                    res = Math.max(res,dp[j][i]);
                }
            }
        }
        return res;
    }
}