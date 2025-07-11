class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for ( String s : tokens ) {
            if ( !s.equals("+") && !s.equals("-") && !s.equals("*") && !s.equals("/") ) stack.push(Integer.valueOf(s));
            else {
                int b = stack.pop();
                int a = stack.pop();
                int tmp = 0;
                switch ( s ) {
                    case "+":
                        tmp = a+b;
                        break;
                    case "-":
                        tmp = a-b;
                        break;
                    case "*":
                        tmp = a*b;
                        break;
                    case "/":
                        tmp = a/b;
                        break;
                }
                stack.push(tmp);
            }
        }
        return stack.peek();
    }
}