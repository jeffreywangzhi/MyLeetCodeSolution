class Solution {
    public boolean validTree(int n, int[][] edges) {
        if (edges.length != n - 1) return false;
        HashMap<Integer,HashSet<Integer>> map = new HashMap<>();
        for ( int i = 0; i < n; i++ ) map.put(i,new HashSet<>());
        for ( int[] edge : edges ) {
            map.get(edge[0]).add(edge[1]);
            map.get(edge[1]).add(edge[0]);
        }
        HashSet<Integer> visited = new HashSet<>();
        if ( !dfs(map,0,-1,visited) ) return false;
        return visited.size() == n;
    }
    private boolean dfs(HashMap<Integer,HashSet<Integer>> map, int start, int pre, HashSet<Integer> visited) {
        if ( visited.contains(start) ) return false;
        visited.add(start);
        for ( int next : map.get(start) ) {
            if ( next == pre ) continue;
            if ( !dfs(map,next,start,visited) ) return false;
        }
        return true;
    }
}