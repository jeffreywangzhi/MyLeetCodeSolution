class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals,Comparator.comparingInt(a->a[0]));
        int[] cur = intervals[0];
        int res = 0;
        for ( int i = 1; i < intervals.length; i++ ) {
            if ( cur[1] > intervals[i][0] ) {
                cur = cur[1] <= intervals[i][1]  ? cur : intervals[i];
                res++;
            } else cur = intervals[i];
        }
        return res;
    }
}