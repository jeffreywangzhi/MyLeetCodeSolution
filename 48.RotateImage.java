class Solution {
    public void rotate(int[][] matrix) {
        for ( int i = 0; i < matrix.length; i++ ) {
            for ( int j = 0; j < i; j++ ) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        for ( int k = 0; k < matrix.length; k++ ){
            for ( int m = 0, n = matrix[k].length-1; m < n; m++, n-- ) {
                int temp = matrix[k][m];
                matrix[k][m] = matrix[k][n];
                matrix[k][n] = temp;
            }
        }
    }
}