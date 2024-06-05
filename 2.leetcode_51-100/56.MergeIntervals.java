class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        List<int[]> res = new ArrayList<>();
        res.add(intervals[0]);
        for ( int i = 1; i < intervals.length; i++ ) {
            if ( res.get(res.size()-1)[1] >= intervals[i][0] )  res.set(res.size()-1, new int[] {res.get(res.size()-1)[0], Math.max(res.get(res.size()-1)[1], intervals[i][1])});
            else res.add(intervals[i]);
        }
        return res.toArray(new int[res.size()][]);
    }
}