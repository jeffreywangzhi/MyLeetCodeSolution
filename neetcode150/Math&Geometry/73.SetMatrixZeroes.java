class Solution {
    public void setZeroes(int[][] matrix) {
        boolean flag = false;
        for ( int i = 0; i < matrix.length; i++ ) {
            for ( int j = 0; j < matrix[0].length; j++ ) {
                if ( i == 0 && matrix[i][j] == 0 ) flag = true;
                else if ( matrix[i][j] == 0 ) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        for ( int i = matrix.length-1; i >= 0; i-- ) {
            for ( int j = matrix[0].length-1; j >= 0; j-- ) {
                if ( flag && i == 0 ) matrix[i][j] = 0;
                else if ( (i != 0) && matrix[i][0] == 0 || matrix[0][j] == 0 ) matrix[i][j] = 0;
            }
        }
    }
}