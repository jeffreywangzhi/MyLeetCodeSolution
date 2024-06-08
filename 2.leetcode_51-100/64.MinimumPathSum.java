class Solution {
    public int minPathSum(int[][] grid) {
        int res[] = new int[grid[0].length];
        res[0] = grid[0][0];
        for ( int i = 0; i < grid.length; i++ ) {
            for ( int j = 0; j < grid[0].length; j++ ) {
                if ( i == 0 && j == 0 ) {
                    continue;
                } else if ( i == 0 && j != 0 ) {
                    res[j] = res[j-1] + grid[i][j];
                } else if ( j == 0 ) {
                    res[j] += grid[i][j];
                } else {
                    res[j] = Math.min( res[j] + grid[i][j], res[j-1] + grid[i][j] );
                }
            }
        }
        return res[res.length-1];
    }
}