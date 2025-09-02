class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals,Comparator.comparingInt(a->a[0]));
        Stack<int[]> stack = new Stack<>();
        stack.push(intervals[0]);
        for ( int[] in : intervals ) {
            int[] pre = stack.peek();
            if ( pre[1] <= in[0] ) stack.push(in);
            else if ( pre[1] > in[1] ) {
                stack.pop();
                stack.push(in);
            }
        }
        return intervals.length-stack.size();
    }
}