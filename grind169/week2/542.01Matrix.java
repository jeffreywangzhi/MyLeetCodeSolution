class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int[][] dp = new int[mat.length][mat[0].length];
        int res1, res2, res3, res4;
        for ( int i = 0; i < mat.length; i++ ) {
            for ( int j = 0; j < mat[0].length; j++ ) {
                if ( mat[i][j] == 0 ) dp[i][j] = 0;
                else {
                    res2 = i-1 >= 0 ? dp[i-1][j] : Integer.MAX_VALUE-100;
                    res4 = j-1 >= 0 ? dp[i][j-1] : Integer.MAX_VALUE-100;
                    dp[i][j] = Math.min(res2,res4)+1;
                }
            }
        }
        for ( int i = mat.length-1; i >= 0; i-- ) {
            for ( int j = mat[0].length-1; j >= 0; j-- ) {
                if ( mat[i][j] == 0 ) dp[i][j] = 0;
                else {
                    res1 = i+1 < mat.length ? dp[i+1][j] : Integer.MAX_VALUE-100;
                    res3 = j+1 < mat[0].length ? dp[i][j+1] : Integer.MAX_VALUE-100;
                    dp[i][j] = Math.min(dp[i][j],Math.min(res1,res3)+1);
                }
            }
        }
        return dp;
    }
}