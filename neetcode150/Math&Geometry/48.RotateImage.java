class Solution {
    public void rotate(int[][] matrix) {
        int l = 0, r = matrix[0].length-1, len = matrix.length-1;
        while ( l < r ) {
            for ( int i = 0; i < r-l; i++ ) {
                int top = l;
                int bottom = r;
                int topLeft = matrix[top][top+i];
                matrix[top][top+i] = matrix[bottom-i][top];
                matrix[bottom-i][top] = matrix[bottom][bottom-i];
                matrix[bottom][bottom-i] = matrix[top+i][bottom];
                matrix[top+i][bottom] = topLeft;
            }
            l++;r--;
        }
    }
}