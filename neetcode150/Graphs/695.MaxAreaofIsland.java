class Solution {
    private static final int [][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};
    public int maxAreaOfIsland(int[][] grid) {
        int res = 0;
        for ( int i = 0; i < grid.length; i++ ) {
            for ( int j = 0; j < grid[0].length; j++ ) {
                if ( grid[i][j] == 1 ) {
                    int area = dfs(grid,i,j);
                    res = Math.max(res,area);
                }
            }
        }
        return res;
    }
    private int dfs(int[][] grid, int i, int j) {
        if ( i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 0 ) return 0;
        grid[i][j] = 0;
        int area = 1;
        for ( int[] dir : dirs ) area += dfs(grid,i+dir[0],j+dir[1]);
        return area;
    }
}