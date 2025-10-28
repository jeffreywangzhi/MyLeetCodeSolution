class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,Comparator.comparingInt(a->a[0]));
        List<int[]> res = new ArrayList<>();
        res.add(intervals[0]);
        for ( int i = 1; i < intervals.length; i++ ) {
            int[] pre = res.get(res.size()-1);
            int[] cur = intervals[i];
            if ( pre[1] < cur[0] ) res.add(cur);
            else pre[1] = Math.max(pre[1],cur[1]);
        }
        return res.toArray(new int[res.size()][]);
    }
}