class Solution {
    private static final int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};
    private class Cell {
        int i;
        int j;
        private Cell(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }
    public void wallsAndGates(int[][] rooms) {
        Queue<Cell> queue = new LinkedList<>();
        for ( int i = 0; i < rooms.length; i++ ) {
            for ( int j = 0; j < rooms[0].length; j++ ) {
                if ( rooms[i][j] == 0 ) queue.offer(new Cell(i,j));
            }
        }
        int step = 0;
        while ( !queue.isEmpty() ) {
            step++;
            int size = queue.size();
            for ( int i = 0; i < size; i++ ) {
                Cell cur = queue.poll();
                for ( int[] dir : dirs ) {
                    int x = cur.i+dir[0];
                    int y = cur.j+dir[1];
                    if ( x < 0 || x >= rooms.length || y < 0 || y >= rooms[0].length ) continue;
                    if ( rooms[x][y] == Integer.MAX_VALUE ) {
                        rooms[x][y] = step;
                        queue.offer(new Cell(x,y));
                    }
                }
            }
        }
    }
}