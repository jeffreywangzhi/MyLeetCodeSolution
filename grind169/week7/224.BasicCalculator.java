class Solution {
    public int calculate(String s) {
        int res = 0;
        Stack<String> stack = new Stack<>();
        for ( int i = 0; i <= s.length(); i++ ) {
            char c;
            if ( i == s.length() ) c = ')';
            else c = s.charAt(i);
            if ( c == ')' || i == s.length() ) {
                int tmp = 0;
                while ( !stack.isEmpty() && !stack.peek().equals("(") ) {
                    if ( stack.peek().equals(" ") ) {
                        stack.pop();
                        continue;
                    } 
                    int cur = Integer.valueOf(stack.pop());
                    while ( !stack.isEmpty() && stack.peek().equals(" ") ) stack.pop();
                    if ( !stack.isEmpty() && stack.peek().equals("-") ) {
                        tmp -= cur;
                        stack.pop();
                    } else if ( !stack.isEmpty() && stack.peek().equals("+") ) {
                        tmp += cur;
                        stack.pop();
                    } else tmp += cur;
                }
                if ( !stack.isEmpty() && stack.peek().equals("(") ) stack.pop();
                stack.push(String.valueOf(tmp));
            } else {
                if ( Character.isDigit(c) ) {
                    int digit = 0;
                    while ( i < s.length() && Character.isDigit(s.charAt(i)) ) {
                        digit = digit * 10 + s.charAt(i)-'0';
                        i++;
                    }
                    i--;
                    stack.push(String.valueOf(digit));
                }
                else stack.push(String.valueOf(c));
            }
        }
        return Integer.valueOf(stack.pop());
    }
}