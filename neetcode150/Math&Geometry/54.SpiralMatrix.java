class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int left = 0, top = 0, right = matrix[0].length-1, down = matrix.length-1;
        List<Integer> res = new ArrayList<>();
        while ( true ) {
            for ( int i = left; i <= right; i++ ) res.add(matrix[top][i]);
            if ( ++top > down ) break;
            for ( int i = top; i <= down; i++ ) res.add(matrix[i][right]);
            if ( --right < left ) break;
            for ( int i = right; i >= left; i-- ) res.add(matrix[down][i]);
            if ( --down < top ) break;
            for ( int i = down; i >= top; i-- ) res.add(matrix[i][left]);
            if ( ++left > right ) break;
        }
        return res;
    }
}