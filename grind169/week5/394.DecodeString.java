class Solution {
    public String decodeString(String s) {
        int curN = 0;
        String curS = "";
        Stack<Object> st = new Stack<>();
        for ( char ch : s.toCharArray() ) {
            if ( ch == '[' ) {
                st.push(curN);
                st.push(curS);
                curN = 0;
                curS = "";
            } else if ( ch == ']' ) {
                String tempS = (String) st.pop();
                int tempN = (int) st.pop();
                curS = tempS + curS.repeat(tempN);
            } else if ( Character.isDigit(ch) ) {
                curN = curN*10 + (ch-'0');
            } else {
                curS += ch;
            }
        }
        return curS;
    }
}