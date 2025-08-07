class Solution {
    private class Node {
        int vertex;
        int weight;
        int sum;
        private Node(int vertex, int weight, int sum) {
            this.vertex = vertex;
            this.weight = weight;
            this.sum = sum;
        }
    }
    public int networkDelayTime(int[][] times, int n, int k) {
        HashMap<Integer,List<Node>> map = new HashMap<>();
        for ( int i = 1; i <= n; i++ ) map.put(i,new ArrayList<>());
        for ( int[] time : times ) map.get(time[0]).add(new Node(time[1],time[2],0));
        PriorityQueue<Node> pq = new PriorityQueue<>((a,b)->a.sum-b.sum);
        pq.offer(new Node(k,0,0));
        boolean[] visited = new boolean[n];
        int res = 0;
        while ( !pq.isEmpty() ) {
            Node cur = pq.poll();
            if ( visited[cur.vertex-1] == true ) continue;
            visited[cur.vertex-1] = true;
            res = Math.max(res,cur.sum);
            for ( Node nei : map.get(cur.vertex) ) {
                if ( visited[nei.vertex-1] == false ) pq.offer(new Node(nei.vertex, nei.weight, cur.sum + nei.weight));
            }
        }
        for ( boolean boo : visited ) {
            if ( boo == false ) return -1;
        }
        return res;
    }
}