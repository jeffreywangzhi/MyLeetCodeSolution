class Solution {
    public int largestRectangleArea(int[] heights) {
        int h[] = Arrays.copyOf(heights,heights.length+1);
        int res = 0;
        Stack<Integer> stack = new Stack<>();
        for ( int i = 0; i < h.length; i++ ) {
            if ( stack.isEmpty() || h[stack.peek()] <= h[i] ) stack.push(i);
            else {
                while ( !stack.isEmpty() && h[stack.peek()] > h[i] ) {
                    int cur = stack.pop();
                    int prevSmall = stack.isEmpty() ? 0 : stack.peek()+1;
                    res = Math.max(res, h[cur] * (i-prevSmall));
                }
                stack.push(i);
            }
        }
        return res;
    }
}