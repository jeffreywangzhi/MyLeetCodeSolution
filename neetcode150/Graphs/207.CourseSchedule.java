class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        HashSet<Integer> visited = new HashSet<>();
        for ( int i = 0; i < numCourses; i++ ) adj.add(new ArrayList<>());
        for ( int[] pre : prerequisites ) adj.get(pre[0]).add(pre[1]);
        for ( int i = 0; i < numCourses; i++ ) {
            if ( !dfs(i,visited,adj) ) return false;
        }
        return true;
    }
    private boolean dfs(int i, HashSet<Integer> visited, List<List<Integer>> adj) {
        if ( adj.get(i).size() == 0 ) return true;
        if ( visited.contains(i) ) return false;
        visited.add(i);
        for ( int c : adj.get(i) ) {
            if ( !dfs(c,visited,adj) ) return false;
        }
        adj.set(i,new ArrayList<>());
        return true;
    }
}