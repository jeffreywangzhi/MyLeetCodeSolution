class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,Comparator.comparingInt(a->a[0]));
        List<int[]> list = new ArrayList<>();
        for ( int[] interval : intervals ) {
            if ( list.isEmpty() ) list.add(interval);
            else {
                int[] pre = list.get(list.size()-1);
                if ( interval[0] <= pre[1] ) pre[1] = Math.max(interval[1],pre[1]);
                else list.add(interval);
            }
        }
        return list.toArray(new int[list.size()][]);
    }
}