class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for ( int i = 0; i < tokens.length; i++ ) {
            if ( !tokens[i].equals("+") && !tokens[i].equals("-") && !tokens[i].equals("*") && !tokens[i].equals("/") ) stack.push(Integer.valueOf(tokens[i]));
            else {
                int b = stack.pop();
                int a = stack.pop();
                if ( tokens[i].equals("+") ) stack.push(a+b);
                else if ( tokens[i].equals("-") ) stack.push(a-b);
                else if ( tokens[i].equals("*") ) stack.push(a*b);
                else if ( tokens[i].equals("/") ) stack.push(a/b);
            }
        }
        return stack.peek();
    }
}