class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        if ( intervals.length == 0 ) return new int[][]{newInterval};
        List<int[]> list = new ArrayList<>();
        for ( int[] in : intervals ) {
            if ( newInterval == null || newInterval[0] > in[1] ) list.add(in);
            else if ( newInterval[1] < in[0] ) {
                list.add(newInterval);
                newInterval = null;
                list.add(in);
            } else {
                newInterval[0] = Math.min(newInterval[0],in[0]);
                newInterval[1] = Math.max(newInterval[1],in[1]);
            }
        }
        if ( newInterval != null ) list.add(newInterval);
        int[][] res = new int[list.size()][2];
        for ( int i = 0; i < list.size(); i++ ) res[i] = list.get(i);
        return res;
    }
}