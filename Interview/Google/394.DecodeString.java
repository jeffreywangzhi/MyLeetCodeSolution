class Solution {
    public String decodeString(String s) {
        String curS = "";
        int curN = 0;
        Stack<Object> stack = new Stack<>();
        for ( char c : s.toCharArray() ) {
            if ( c == '[' ) {
                stack.push(curN);
                stack.push(curS);
                curS = "";
                curN = 0;
            } else if ( c == ']' ) {
                String tmpS = (String)stack.pop();
                int tmpN = (int)stack.pop();
                curS = tmpS + curS.repeat(tmpN);
            } else if ( Character.isDigit(c) ) {
                curN = curN*10 + c-'0';
            } else {
                curS += c;
            }
        }
        return curS;
    }
}