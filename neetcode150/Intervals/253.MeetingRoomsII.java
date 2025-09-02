class Solution {
    public int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals,Comparator.comparingInt(a->a[0]));
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b)->a[1]-b[1]);
        for ( int[] in : intervals ) {
            if ( !minHeap.isEmpty() && minHeap.peek()[1] <= in[0] ) minHeap.poll();
            minHeap.offer(in);
        }
        return minHeap.size();
    }
}