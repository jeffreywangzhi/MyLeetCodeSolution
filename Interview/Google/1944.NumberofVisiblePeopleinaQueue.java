class Solution {
    public int[] canSeePersonsCount(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[heights.length];
        stack.push(heights[heights.length-1]);
        for ( int i = heights.length-2; i >= 0; i-- ) {
            int cur = 0;
            while ( !stack.isEmpty() && stack.peek() < heights[i] ) {
                cur++;
                stack.pop();
            }
            if ( !stack.isEmpty() ) cur++;
            res[i] = cur;
            stack.push(heights[i]);
        }
        return res;
    }
}