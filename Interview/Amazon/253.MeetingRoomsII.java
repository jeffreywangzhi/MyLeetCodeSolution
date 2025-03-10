class Solution {
    public int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals,Comparator.comparingInt(a->a[0]));
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[1]-b[1]);
        for ( int[] interval : intervals ) {
            if ( !pq.isEmpty() && pq.peek()[1] <= interval[0] ) pq.poll();
            pq.offer(interval);
        }
        return pq.size();
    }
}