class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for ( int i = 0; i < numCourses; i++ ) {
            adj.add(new ArrayList<>());
        }
        for ( int i = 0; i < prerequisites.length; i++ ) {
            adj.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
        int[] indegree = new int[numCourses];
        for ( int i = 0; i < adj.size(); i++ ) {
            for ( int course : adj.get(i) ) indegree[course]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        for ( int i = 0; i < indegree.length; i++ ) {
            if ( indegree[i] == 0 ) queue.offer(i);
        }
        int res = 0;
        while ( !queue.isEmpty() ) {
            int cur = queue.poll();
            res++;
            for ( int course : adj.get(cur) ) {
                if ( --indegree[course] == 0 ) queue.offer(course);
            }
        }
        return res == numCourses ? true : false;
    }
}