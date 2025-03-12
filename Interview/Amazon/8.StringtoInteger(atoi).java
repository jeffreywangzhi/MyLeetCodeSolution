class Solution {
    public int myAtoi(String s) {
        s = s.trim();
        if ( s.length() == 0 ) return 0;
        boolean pos = s.charAt(0) == '+';
        boolean neg = s.charAt(0) == '-';
        int i = 0, ans = 0;
        if ( pos || neg ) i++;
        for ( ; i < s.length() && Character.isDigit(s.charAt(i)); i++ ) {
            int digit = s.charAt(i)-'0';
            if ( ans > Integer.MAX_VALUE/10 || ( ans == Integer.MAX_VALUE/10 && digit > Integer.MAX_VALUE%10) ) {
                return neg ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
            ans = ans*10+digit;
        }
        return neg ? -ans : ans;
    }
}