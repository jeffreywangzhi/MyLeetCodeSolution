class Solution {
    public int numIslands(char[][] grid) {
        int[][] rec = new int[grid.length][grid[0].length];
        int cnt = 0;
        for ( int i = 0; i < grid.length; i++ ) {
            for ( int j = 0; j < grid[0].length; j++ ) {
                if ( grid[i][j]-'0' == 0 || rec[i][j] == -1 ) continue;
                else {
                    helper(grid,rec,i,j);
                    cnt++;
                }
            }
        }
        return cnt;
    }
    private void helper(char[][] grid, int[][] rec, int i, int j) {
        if ( i < 0 || i >= grid.length || j < 0 || j >= grid[0].length ) return;
        if ( grid[i][j]-'0' == 0 || rec[i][j] == -1 ) return;
        rec[i][j] = -1;
        helper(grid,rec,i+1,j);
        helper(grid,rec,i-1,j);
        helper(grid,rec,i,j+1);
        helper(grid,rec,i,j-1);
    }
}