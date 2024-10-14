class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> a[0]-b[0]);
        int[] head = intervals[0];
        int res = 0;
        for ( int i = 1; i < intervals.length; i++ ) {
            if ( head[1] > intervals[i][0] ) {
                intervals[i] = head[1] > intervals[i][1] ? intervals[i] : head;
                res++;
            }
            head = intervals[i];
        }
        return res;
    }
}