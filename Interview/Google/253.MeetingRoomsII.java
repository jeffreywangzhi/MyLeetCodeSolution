class Solution {
    public int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals,Comparator.comparingInt(a->a[0]));
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b)->a[1]-b[1]);
        minHeap.offer(intervals[0]);
        for ( int i = 1; i < intervals.length; i++ ) {
            if ( minHeap.peek()[1] <= intervals[i][0] ) minHeap.poll();
            minHeap.offer(intervals[i]);
        }
        return minHeap.size();
    }
}