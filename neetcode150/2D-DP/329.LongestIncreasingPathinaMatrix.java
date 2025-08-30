class Solution {
    private final int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};
    public int longestIncreasingPath(int[][] matrix) {
        int[][] dp = new int[matrix.length][matrix[0].length];
        int[] res = new int[1];
        for ( int i = 0; i < matrix.length; i++ ) {
            for ( int j = 0; j < matrix[0].length; j++ ) {
                if ( dp[i][j] == 0 ) dfs(matrix,dp,res,i,j,Long.MAX_VALUE);
            }
        }
        return res[0];
    }
    public int dfs(int[][] matrix, int[][] dp, int[] res, int i, int j, long pre) {
        if ( i < 0 || i >= matrix.length || j < 0 || j >= matrix[0].length ) return 0;
        if ( matrix[i][j] >= pre ) return 0;
        if ( dp[i][j] != 0 ) return dp[i][j];
        int cur = 0;
        for ( int[] dir : dirs ) cur = Math.max(cur,dfs(matrix,dp,res,i+dir[0],j+dir[1],matrix[i][j]));
        dp[i][j] = cur+1;
        res[0] = Math.max(res[0],dp[i][j]);
        return dp[i][j];
    }
}