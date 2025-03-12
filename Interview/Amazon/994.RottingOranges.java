class Solution {
    private class Orange {
        int i;
        int j;
        private Orange(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }
    private Queue<Orange> queue = new LinkedList<>();
    public int orangesRotting(int[][] grid) {
        boolean flag = false;
        for ( int i = 0; i < grid.length; i++ ) {
            for ( int j = 0; j < grid[0].length; j++ ) {
                if ( grid[i][j] == 2 ) queue.offer(new Orange(i,j));
                if ( grid[i][j] == 1 ) flag = true;
            }
        }
        if ( !flag ) return 0;
        int res = 0;
        while ( !queue.isEmpty() ) {
            int size = queue.size();
            for ( int i = 0; i < size; i++ ) {
                Orange o = queue.poll();
                helper(grid,o.i,o.j,0);
            }
            res++;
        }
        for ( int i = 0; i < grid.length; i++ ) {
            for ( int j = 0; j < grid[0].length; j++ ) {
                if ( grid[i][j] == 1 ) return -1;
            }
        }
        return res-1;
    }
    private void helper(int[][] grid, int i, int j, int level) {
        if ( i < 0 || i >= grid.length || j < 0 || j >= grid[0].length ) return;
        if ( grid[i][j] == 1 ) {
            grid[i][j] = 2;
            queue.offer(new Orange(i,j));
        }
        if ( level == 1 ) return;
        else {
            helper(grid,i+1,j,1);
            helper(grid,i-1,j,1);
            helper(grid,i,j+1,1);
            helper(grid,i,j-1,1);
        }
    }
}