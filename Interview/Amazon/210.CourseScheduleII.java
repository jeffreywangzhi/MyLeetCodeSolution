class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // build graph
        List<List<Integer>> adj = new ArrayList<>();
        for ( int i = 0; i < numCourses; i++ ) adj.add(new ArrayList<>());
        for ( int[] pre : prerequisites ) adj.get(pre[1]).add(pre[0]);
        // calculate indegree
        int[] indegree = new int[numCourses];
        for ( List<Integer> list : adj ) {
            for ( int course : list ) indegree[course]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        for ( int i = 0; i < indegree.length; i++ ) {
            if ( indegree[i] == 0 ) queue.offer(i);
        }
        List<Integer> res = new ArrayList<>();
        // start queue bfs
        while ( !queue.isEmpty() ) {
            int cur = queue.poll();
            res.add(cur);
            for ( int course : adj.get(cur) ) {
                if ( --indegree[course] == 0 ) queue.offer(course);
            }
        }
        if ( res.size() != numCourses ) return new int[0];
        int[] result = new int[numCourses];
        for ( int i = 0; i < res.size(); i++ ) result[i] = res.get(i);
        return result;
    }
}