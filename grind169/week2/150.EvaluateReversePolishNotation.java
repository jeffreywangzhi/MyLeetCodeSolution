class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for ( String str : tokens ) {
            if ( !str.equals("+") && !str.equals("-") && !str.equals("*") && !str.equals("/") ) {
                stack.push(Integer.parseInt(str));
            } else {
                int n1 = stack.pop(), n2 = stack.pop();
                switch( str ) {
                    case "+":
                        stack.push(n1 + n2);
                        break;
                    case "-":
                        stack.push(n2 - n1);
                        break;
                    case "*":
                        stack.push(n1 * n2);
                        break;
                    case "/":
                        stack.push(n2 / n1);
                        break;
                }
            }
        }
        return stack.peek();
    }
}