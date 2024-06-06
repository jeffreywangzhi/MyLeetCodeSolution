class Solution {
    public int uniquePaths(int m, int n) {
        if ( m == 1 && n == 1 ) return 1;
        int[][] res = new int[m][n];
        for ( int i = 0; i < m; i++ ) {
            for ( int j = 0; j < n; j++ ) {
                if ( i == 0 && j == 0 ) {
                    res[i][j] = 0;
                } else if ( i == 0 || j == 0 ) {
                    res[i][j] = 1;
                } else {
                    res[i][j] = res[i-1][j] + res[i][j-1];
                }
            }
        }
        return res[m-1][n-1];
    }
}