class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n == 1) return Arrays.asList(0);
        List<HashSet<Integer>> adj = new ArrayList<>(n);
        for ( int i = 0; i < n; i++ ) adj.add(new HashSet<Integer>());
        for ( int[] edge : edges ) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        List<Integer> leaves = new ArrayList<>();
        for ( int i = 0; i < adj.size(); i++ ) {
            if ( adj.get(i).size() == 1 ) leaves.add(i);
        }
        while ( n > 2 ) {
            List<Integer> newleaves = new ArrayList<>();
            n -= leaves.size();
            for ( int i : leaves ) {
                int t = adj.get(i).iterator().next();
                adj.get(t).remove(i);
                if ( adj.get(t).size() == 1 ) newleaves.add(t);
            }
            leaves = newleaves;
        }
        return leaves;
    }
}