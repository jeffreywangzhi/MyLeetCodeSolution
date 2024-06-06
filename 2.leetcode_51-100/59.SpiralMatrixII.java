class Solution {
    public int[][] generateMatrix(int n) {
        int up = 0, right = n - 1, down = n - 1, left = 0;
        int[][] res = new int[n][n];
        int num = 1;
        while ( true ) {
            for ( int i = left; i <= right; i++ ) {res[up][i] = num; num++;}
            if ( ++up > down ) break;
            for ( int i = up; i <= down; i++ ) {res[i][right] = num; num++;}
            if ( --right < left ) break;
            for ( int i = right; i >= left; i-- ) {res[down][i] = num; num++;}
            if ( --down < up ) break;
            for ( int i = down; i >= up; i-- ) {res[i][left] = num; num++;}
            if ( ++left > right ) break;
        }
        return res;
    }
}