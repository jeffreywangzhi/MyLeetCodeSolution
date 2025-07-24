class Solution {
    private class Point {
        int[] xy;
        double dis;
        private Point(int[] xy, double dis) {
            this.xy = xy;
            this.dis = dis;
        }
    }
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Point> pq = new PriorityQueue<>((a,b)->Double.compare(a.dis,b.dis));
        for ( int[] xy : points ) {
            double dis = Math.pow(Math.pow(xy[0],2)+Math.pow(xy[1],2),0.5);
            pq.offer(new Point(xy,dis));
        }
        int[][] res = new int[k][2];
        for ( int i = 0; i < k; i++ ) res[i] = pq.poll().xy;
        return res;
    }
}