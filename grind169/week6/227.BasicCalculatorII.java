class Solution {
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        int num = 0, res = 0;
        char sign = '+';
        for ( int i = 0; i < s.length(); i++ ) {
            if ( Character.isDigit(s.charAt(i)) ) {
                num = s.charAt(i) - '0';
                while ( i+1 < s.length() && Character.isDigit(s.charAt(i+1)) ) {
                    num = num * 10 + s.charAt(i+1) - '0';
                    i++;
                }
            }
            if ( !Character.isDigit(s.charAt(i)) && s.charAt(i) != ' ' || i == s.length()-1 ) {
                if ( sign == '+' ) stack.push(num);
                if ( sign == '-' ) stack.push(-num);
                if ( sign == '*' ) stack.push(stack.pop()*num);
                if ( sign == '/' ) stack.push(stack.pop()/num);
                sign = s.charAt(i);
                num = 0;
            }
        }
        for ( int e : stack ) res += e;
        return res;
    }
}