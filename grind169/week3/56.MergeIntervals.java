class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(p->p[0]));
        List<int[]> res = new ArrayList<>();
        for ( int i = 0; i < intervals.length; i++ ) {
            if ( res.isEmpty() || !(res.get(res.size()-1)[1] >= intervals[i][0]) ) res.add(intervals[i]);
            else res.set(res.size()-1, new int[] {Math.min(res.get(res.size()-1)[0],intervals[i][0]),Math.max(res.get(res.size()-1)[1],intervals[i][1])});
        }
        return res.toArray(new int[res.size()][2]);
    }
}