class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int bs1row = bs1(matrix, target, 0, matrix.length-1);
        return bs2(matrix, target, 0, matrix[0].length-1, bs1row);
    }
    private int bs1(int[][] matrix, int target, int start, int end) {
        int mid = ( start + end ) / 2;
        if ( mid == 0 && mid == matrix.length-2 ) {return matrix[mid+1][0] <= target ? 1 : 0;}
        else if ( mid == 0 || mid == matrix.length-1 ) {return mid;}
        else if ( matrix[mid][0] <= target && target < matrix[mid+1][0] ) {return mid;}
        else if ( matrix[mid-1][0] <= target && target < matrix[mid][0] ) {return mid-1;}
        else return matrix[mid][0] < target ? bs1(matrix, target, mid+1, end) : bs1(matrix, target, start, mid);
    }
    private boolean bs2(int[][] matrix, int target, int start, int end, int row) {
        if ( start >= end && matrix[row][start] != target ) return false;
        int mid = ( start + end ) / 2;
        if ( matrix[row][mid] == target ) return true;
        else return matrix[row][mid] < target ? bs2(matrix, target, mid+1, end, row) : bs2(matrix, target, start, mid, row);
    }
}