class Solution {
    public int numIslands(char[][] grid) {
        int res = 0;
        for ( int i = 0; i < grid.length; i++ ) {
            for ( int j = 0; j < grid[0].length; j++ ) {
                if ( grid[i][j] == '1' ) {
                    helper(i,j,grid);
                    res++;
                }
            }
        }
        return res;
    }
    private void helper(int i, int j, char[][] grid) {
        if ( i < 0 || i >= grid.length || j < 0 || j >= grid[0].length ) return;
        if ( grid[i][j] != '1' ) return;
        grid[i][j] = '#';
        helper(i+1,j,grid);
        helper(i-1,j,grid);
        helper(i,j+1,grid);
        helper(i,j-1,grid);
    }
}