class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = bs1(matrix,target);
        return row == -1 ? false : bs2(matrix,target,row);
    }
    public int bs1(int[][] matrix, int target) {
        int start = 0, end = matrix.length;
        while ( start < end ) {
            int mid = start + ( end - start ) / 2;
            if ( matrix[mid][0] <= target && matrix[mid][matrix[0].length-1] >= target ) return mid;
            if ( matrix[mid][0] > target ) end = mid;
            else start = mid+1;
        }
        return -1;
    }
    public boolean bs2(int[][] matrix, int target, int row) {
        int start = 0, end = matrix[0].length;
        while ( start < end ) {
            int mid = start + ( end - start ) / 2;
            if ( matrix[row][mid] == target ) return true;
            if ( matrix[row][mid] > target ) end = mid;
            else start = mid+1;
        }
        return false;
    }
}