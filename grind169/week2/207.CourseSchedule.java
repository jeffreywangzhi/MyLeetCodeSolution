class Solution {
public boolean canFinish(int numCourses, int[][] prerequisites) {
    ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
    for ( int i = 0; i < numCourses; i++ ) {
        adj.add(new ArrayList<>());
    }
    for ( int i = 0; i < prerequisites.length; i++ ) {
        adj.get(prerequisites[i][0]).add(prerequisites[i][1]);
    }
    int[] indegree = new int[numCourses];
    Queue<Integer> queue = new LinkedList<Integer>();
    for ( int i = 0; i < numCourses; i++ ) {
        for ( int t : adj.get(i) ) {
            indegree[t]++;
        }
    }
    for ( int i = 0; i < numCourses; i++ ) {
        if ( indegree[i] == 0 ) queue.add(i);
    }
    ArrayList<Integer> res = new ArrayList<>();
    while ( !queue.isEmpty() ) {
        int n = queue.poll();
        res.add(n);
        for ( int t : adj.get(n) ) {
            if ( --indegree[t] == 0 ) queue.add(t);
        }
    }
    return res.size() == numCourses;
}
}