class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack<>();
        for ( int i = 0; i < temperatures.length; i++ ) {
            if ( stack.isEmpty() ) {
                stack.push(i);
                continue;
            }
            while ( !stack.isEmpty() && temperatures[i] > temperatures[stack.peek()] ) {
                int cur = stack.pop();
                temperatures[cur] = i-cur;
            }
            stack.push(i);
        }
        while ( !stack.isEmpty() ) temperatures[stack.pop()] = 0;
        return temperatures;
    }
}