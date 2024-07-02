class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        ArrayList<int[]> res = new ArrayList<>();
        int cur = 0;
        for ( int i = 0; i < intervals.length; i++ ) {
            if ( newInterval[0] > intervals[i][1] ) {
                res.add(intervals[i]);
                cur++;
            } else if ( newInterval[1] < intervals[i][0] ) {
                res.add(intervals[i]);
            } else {
                newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
                newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            }
        }
        res.add(cur, newInterval);
        return res.toArray(new int[res.size()][]);
    }
}