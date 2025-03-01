class Solution {
    private int max = 0;
    public int longestIncreasingPath(int[][] matrix) {
        int[][] memo = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                helper(i, j, -1, 0, matrix, memo);
            }
        }
        return max;
    }
    
    private void helper(int i, int j, int pre, int level, int[][] matrix, int[][] memo) {
        if (i < 0 || i >= matrix.length || j < 0 || j >= matrix[0].length) return;
        if (matrix[i][j] <= pre) return;
        if (memo[i][j] >= level + 1) return;
        level++;
        max = Math.max(max, level);
        memo[i][j] = level;
        helper(i+1, j, matrix[i][j], level, matrix, memo);
        helper(i-1, j, matrix[i][j], level, matrix, memo);
        helper(i, j+1, matrix[i][j], level, matrix, memo);
        helper(i, j-1, matrix[i][j], level, matrix, memo);
    }
}