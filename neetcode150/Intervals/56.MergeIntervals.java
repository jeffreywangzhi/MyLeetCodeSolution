class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,Comparator.comparingInt(a->a[0]));
        List<int[]> list = new ArrayList<>();
        list.add(intervals[0]);
        for ( int[] in : intervals ) {
            int[] pre = list.get(list.size()-1);
            if ( in[0] > pre[1] ) list.add(in);
            else {
                pre[0] = Math.min(pre[0],in[0]);
                pre[1] = Math.max(pre[1],in[1]);
            }
        }
        int[][] res = new int[list.size()][];
        for ( int i = 0; i < list.size(); i++ ) res[i] = list.get(i);
        return res;
    }
}