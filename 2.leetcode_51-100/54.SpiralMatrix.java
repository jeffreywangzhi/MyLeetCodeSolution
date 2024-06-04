class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int up = 0, right = matrix[0].length - 1, down = matrix.length - 1, left = 0;
        List<Integer> res = new ArrayList<>();
        while ( true ) {
            for ( int i = left; i <= right; i++ ) res.add(matrix[up][i]);
            if ( ++up > down ) break;
            for ( int i = up; i <= down; i++ ) res.add(matrix[i][right]);
            if ( --right < left ) break;
            for ( int i = right; i >= left; i-- ) res.add(matrix[down][i]);
            if ( --down < up ) break;
            for ( int i = down; i >= up; i-- ) res.add(matrix[i][left]);
            if ( ++left > right ) break;
        }
        return res;
    }
}