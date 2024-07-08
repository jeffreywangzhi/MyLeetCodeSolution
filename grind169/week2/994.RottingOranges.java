class Solution {
    public int orangesRotting(int[][] grid) {
        int[][] pre = grid;
        int[][] rec = new int[grid.length][grid[0].length];
        int cnt = 0;
        while ( true ) {
            boolean flag = false;
            for ( int i = 0; i < grid.length; i++ ) {
                for ( int j = 0; j < grid[0].length; j++ ) {
                    if ( grid[i][j] == 2 ) {
                        rec[i][j] = 2;
                        helper(grid, rec, i+1, j);
                        helper(grid, rec, i-1, j);
                        helper(grid, rec, i, j+1);
                        helper(grid, rec, i, j-1);
                    } else {
                        rec[i][j] = rec[i][j] == 2 ? 2 : grid[i][j];
                    }
                    if ( rec[i][j] == 1 ) flag = true;
                }
            }
            if ( Arrays.deepEquals(grid,rec) == true ) return flag ? -1 : cnt;
            grid = rec;
            rec = new int[grid.length][grid[0].length];
            cnt++;
        }
        
    }
    private void helper(int[][] grid, int[][] rec, int i, int j) {
        if ( i < 0 || i >= grid.length || j < 0 || j >= grid[0].length ) return;
        if ( grid[i][j] == 0 || grid[i][j] == 2 ) return;
        else rec[i][j] = 2;
    }
}