class Solution {
    public int maximalSquare(char[][] matrix) {
        int[][] dp = new int[matrix.length+1][matrix[0].length+1];
        int res = 0;
        for ( int i = 0; i < matrix.length; i++ ) {
            for ( int j = 0; j < matrix[0].length; j++ ) {
                if ( matrix[i][j] == '1' ) {
                    dp[i+1][j+1] = Math.min(dp[i][j+1],Math.min(dp[i+1][j],dp[i][j]))+1;
                    res = Math.max(res,dp[i+1][j+1]);
                }
            }
        }
        return res*res;
    }
}