class Solution {
    private class Pair {
        int val;
        int row;
        private Pair(int val, int row) {
            this.val = val;
            this.row = row;
        }
    }
    public long maxSum(int[][] grid, int[] limits, int k) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->b.val-a.val);
        for ( int i = 0; i < grid.length; i++ ) {
            for ( int j = 0; j < grid[0].length; j++ ) pq.offer(new Pair(grid[i][j],i));
        }
        long res = 0;
        while ( k > 0 ) {
            Pair cur = pq.poll();
            if ( limits[cur.row]-- <= 0 ) continue;
            res += cur.val;
            k--;
        }
        return res;
    }
}