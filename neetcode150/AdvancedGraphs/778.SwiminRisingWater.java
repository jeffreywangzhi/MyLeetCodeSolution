class Solution {
    private static final int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};
    private class Cell {
        int time;
        int i, j;
        private Cell(int time, int i, int j) {
            this.time = time;
            this.i = i;
            this.j = j;
        }
    }
    public int swimInWater(int[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        PriorityQueue<Cell> pq = new PriorityQueue<>((a,b)->a.time-b.time);
        pq.offer(new Cell(grid[0][0],0,0));
        int time = 0;
        while ( true ) {
            while ( !pq.isEmpty() && pq.peek().time <= time ) {
                Cell cur = pq.poll();
                if ( visited[cur.i][cur.j] ) continue;
                if ( cur.i == grid.length-1 && cur.j == grid[0].length-1 ) return time;
                visited[cur.i][cur.j] = true;
                for ( int[] dir : dirs ) {
                    int nexti = cur.i+dir[0];
                    int nextj = cur.j+dir[1];
                    if ( nexti < 0 || nexti >= grid.length || nextj < 0 || nextj >= grid[0].length ) continue;
                    if ( visited[nexti][nextj] ) continue;
                    else pq.offer(new Cell(grid[nexti][nextj],nexti,nextj));
                }
            }
            time++;
        }
    }
}