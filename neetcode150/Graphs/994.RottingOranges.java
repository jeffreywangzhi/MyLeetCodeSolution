class Solution {
    private static final int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};
    public int orangesRotting(int[][] grid) {
        Queue<int[]> queue = new LinkedList<>();
        boolean rot = false, fresh = false;
        for ( int i = 0; i < grid.length; i++ ) {
            for ( int j = 0; j < grid[0].length; j++ ) {
                if ( grid[i][j] == 2 ) {
                    queue.offer(new int[]{i,j});
                    rot = true;
                } else if ( grid[i][j] == 1 ) fresh = true;
            }
        }
        int time = 0;
        if ( queue.isEmpty() ) {
            if ( !fresh ) return 0;
            if ( !rot ) return -1;
        }
        while ( !queue.isEmpty() ) {
            int size = queue.size();
            boolean rotted = false;
            for ( int i = 0; i < size; i++ ) {
                int[] cur = queue.poll();
                for ( int[] dir : dirs ) {
                    int x = cur[0]+dir[0];
                    int y = cur[1]+dir[1];
                    if ( x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || grid[x][y] != 1 ) continue;
                    grid[x][y] = 2;
                    rotted = true;
                    queue.offer(new int[]{x,y});
                }
            }
            if ( rotted ) time++;
        }
        for ( int i = 0; i < grid.length; i++ ) {
            for ( int j = 0; j < grid[0].length; j++ ) {
                if ( grid[i][j] == 1 ) return -1;
            }
        }
        return time;
    }
}