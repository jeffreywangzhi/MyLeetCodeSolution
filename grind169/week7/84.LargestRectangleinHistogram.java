class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int arr[] = Arrays.copyOf(heights,heights.length+1);
        arr[arr.length-1] = 0;
        int res = 0;
        for ( int i = 0; i < arr.length; i++ ) {
            if ( stack.isEmpty() || arr[i] >= arr[stack.peek()] ) stack.push(i);
            else {
                while ( !stack.isEmpty() && arr[stack.peek()] > arr[i] ) {
                    int cur = stack.pop();
                    int width = stack.isEmpty() ? i : (i - stack.peek() - 1);
                    res = Math.max(res,width*arr[cur]);
                    width++;
                }
                stack.push(i);
            }
        }
        return res;
    }
}