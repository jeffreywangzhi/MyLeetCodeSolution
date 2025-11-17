class Solution {
    public int minOperations(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int res = 0;
        for ( int n : nums ) {
            while ( !stack.isEmpty() && stack.peek() > n ) stack.pop();
            if ( n == 0 ) continue;
            if ( stack.isEmpty() || stack.peek() < n ) res++;
            stack.push(n);
        }
        return res;
    }
}