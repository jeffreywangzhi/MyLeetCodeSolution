class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length, col = matrix[0].length;
        int start = 0, end = row*col-1;
        while ( start <= end ) {
            int mid = start+(end-start)/2;
            int r = mid/col;
            int c = mid%col;
            int val = matrix[r][c];
            if ( val == target ) return true;
            if ( val > target ) end = mid-1;
            else start = mid+1;
        }
        return false;
    }
}