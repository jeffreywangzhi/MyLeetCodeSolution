class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        for ( int i = 0; i < numCourses; i++ ) adj.add(new ArrayList<>());
        for ( int[] pre : prerequisites ) adj.get(pre[1]).add(pre[0]);
        int[] indegree = new int[numCourses];
        for ( int i = 0; i < adj.size(); i++ ) {
            for ( int c : adj.get(i) ) indegree[c]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        for ( int i = 0; i < indegree.length; i++ ) {
            if ( indegree[i] == 0 ) queue.offer(i);
        }
        int[] res = new int[numCourses];
        int idx = 0;
        while ( !queue.isEmpty() ) {
            int cur = queue.poll();
            res[idx++] = cur;
            for ( int c : adj.get(cur) ) {
                if ( --indegree[c] == 0 ) queue.offer(c);
            }
        }
        return idx == numCourses ? res : new int[0];
    }
}