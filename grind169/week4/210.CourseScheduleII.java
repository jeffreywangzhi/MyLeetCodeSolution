class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Integer> res = new ArrayList<>();
        List<HashSet<Integer>> adj = new ArrayList<>();
        int[] in = new int[numCourses];
        for ( int i = 0; i < numCourses; i++ ) adj.add(new HashSet<>());
        for ( int i = 0; i < prerequisites.length; i++ ) {
            adj.get(prerequisites[i][1]).add(prerequisites[i][0]);
            in[prerequisites[i][0]]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        for ( int i = 0; i < numCourses; i++ ) if ( in[i] == 0 ) queue.add(i);
        while ( !queue.isEmpty() ) {
            int course = queue.poll();
            res.add(course);
            for ( int num : adj.get(course) ) {
                if ( --in[num] == 0 ) queue.add(num);
            }
        }
        if ( res.size() != numCourses ) return new int[0];
        int[] result = new int[numCourses];
        for ( int i = 0; i < res.size(); i++ ) result[i] = res.get(i);
        return result;
    }
}