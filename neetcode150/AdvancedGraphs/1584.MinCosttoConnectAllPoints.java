class Solution {
    public int minCostConnectPoints(int[][] points) {
        HashMap<Integer,List<int[]>> adj = new HashMap<>();
        for ( int i = 0; i < points.length; i++ ) {
            for ( int j = 0; j < points.length; j++ ) {
                if ( i != j ) {
                    int dist = Math.abs(points[i][0]-points[j][0])+Math.abs(points[i][1]-points[j][1]);
                    adj.computeIfAbsent(i,k->new ArrayList<>()).add(new int[]{dist,j});
                }
            }
        }
        HashSet<Integer> visited = new HashSet<>();
        int res = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[0]-b[0]);
        pq.offer(new int[]{0,0});
        while ( visited.size() < points.length ) {
            int[] cur = pq.poll();
            if ( visited.contains(cur[1]) ) continue;
            visited.add(cur[1]);
            res += cur[0];
            for ( int[] nei : adj.getOrDefault(cur[1],Collections.emptyList()) ) {
                if ( !visited.contains(nei[1]) ) pq.offer(nei);
            }
        }
        return res;
    }
}