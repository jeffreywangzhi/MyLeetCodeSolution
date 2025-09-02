class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {
        Arrays.sort(intervals,Comparator.comparingInt(a->a[0]));
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b)->a[0]-b[0]);
        HashMap<Integer,Integer> map = new HashMap<>();
        int[] newq = new int[queries.length];
        for ( int i = 0; i < queries.length; i++ ) newq[i] = queries[i];
        Arrays.sort(newq);
        int i = 0;
        for ( int q : newq ) {
            while ( i < intervals.length && intervals[i][0] <= q ) {
                minHeap.offer(new int[] {intervals[i][1]-intervals[i][0]+1,intervals[i][1]});
                i++;
            }
            while ( !minHeap.isEmpty() && minHeap.peek()[1] < q ) minHeap.poll();
            int cur = 0;
            if ( minHeap.isEmpty() ) cur = -1;
            else cur = minHeap.peek()[0];
            map.put(q,cur);
        }
        int[] res = new int[queries.length];
        for ( int idx = 0; idx < res.length; idx++ ) res[idx] = map.get(queries[idx]);
        return res;
    }
}