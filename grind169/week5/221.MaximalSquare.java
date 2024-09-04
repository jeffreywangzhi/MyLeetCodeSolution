class Solution {
    public int maximalSquare(char[][] matrix) {
        int dp[][] = new int[matrix.length][matrix[0].length];
        int max = 0;
        for ( int i = matrix.length-1; i >= 0; i-- ) {
            for ( int j = matrix[0].length-1; j >= 0; j-- ) {
                if ( matrix[i][j] == '0' ) continue;
                if ( i == matrix.length-1 || j == matrix[0].length-1 ) dp[i][j] = 1;
                else dp[i][j] = Math.min(Math.min(dp[i+1][j],dp[i][j+1]),dp[i+1][j+1])+1;
                if ( dp[i][j] > max ) max = dp[i][j];
            }
        }
        return max*max;
    }
}