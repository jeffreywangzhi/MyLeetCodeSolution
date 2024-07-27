class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] res = new int[temperatures.length];
        Stack<Integer> stack = new Stack<Integer>();
        for ( int i = 0; i < temperatures.length; i++ ) {
            while ( !stack.empty() && temperatures[i] > temperatures[stack.peek()] ) {
                res[stack.peek()] = i - stack.pop();
            }
            stack.push(i);
        }
        return res;
    }
}