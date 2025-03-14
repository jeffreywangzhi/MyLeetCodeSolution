class Solution {
    public int calculate(String s) {
        Stack<String> stack = new Stack<>();
        char sign = '+';
        int res = 0;
        for ( int i = 0; i < s.length(); i++ ) {
            char cur = s.charAt(i);
            if ( cur == ' ' ) continue;
            if ( cur == '(' ) {stack.push(String.valueOf(sign));sign = '+';stack.push("(");continue;}
            if ( cur == '+' || cur == '-' ) {sign = cur;continue;}
            if ( cur == ')' ) {
                int tmp = 0;
                while ( !stack.peek().equals("(") ) tmp += Integer.valueOf(stack.pop());
                stack.pop();
                String t = tmp < 0 ? Integer.toString(tmp) : '+'+Integer.toString(tmp);
                if ( stack.isEmpty() ) stack.push(t);
                else if ( stack.peek().equals("+")) {
                    stack.pop();
                    stack.push(t);
                } else {
                    stack.pop();
                    if ( t.charAt(0) == '-' ) {
                        char[] arr = t.toCharArray();
                        arr[0] = '+';
                        t = new String(arr);
                        stack.push(t);
                    } else {
                        char[] arr = t.toCharArray();
                        arr[0] = '-';
                        t = new String(arr);
                        stack.push(t);
                    }
                    
                }
            } else {
                StringBuilder num = new StringBuilder();
                num.append(sign);
                while ( Character.isDigit(cur) ) {
                    num.append(cur);
                    if ( ++i < s.length() ) cur = s.charAt(i);
                    else break;
                }
                i--;
                stack.push(num.toString());
            }
        }
        while ( !stack.isEmpty() ) {
            res += Integer.valueOf(stack.pop());
        }
        return res;
    }
}