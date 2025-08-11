class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<int[]>> adj = new ArrayList<>();
        for ( int i = 0; i < n; i++ ) adj.add(new ArrayList<>());
        for ( int[] f : flights ) adj.get(f[0]).add(new int[]{f[1],f[2]});
        int[] res = new int[n];
        Arrays.fill(res,Integer.MAX_VALUE);
        res[src] = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(src);
        for ( int i = 0; i < k+1; i++ ) {
            int[] tmp = Arrays.copyOf(res,n);
            int size = queue.size();
            if ( size == 0 ) break;
            HashSet<Integer> next = new HashSet<>();
            for ( int j = 0; j < size; j++ ) {
                int cur = queue.poll();
                if ( res[cur] == Integer.MAX_VALUE ) continue;
                for ( int[] nei : adj.get(cur) ) {
                    if ( tmp[nei[0]] > res[cur]+nei[1] ) {
                        tmp[nei[0]] = res[cur]+nei[1];
                        next.add(nei[0]);
                    }
                }
            }
            res = tmp;
            for ( int v : next ) queue.offer(v);
        }
        return res[dst] != Integer.MAX_VALUE ? res[dst] : -1;
    }
}