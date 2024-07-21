class Solution {
    public int myAtoi(String s) {
        s = s.trim();
        if ( s.length() == 0 ) return 0;
        boolean pos = s.charAt(0) == '+';
        boolean neg = s.charAt(0) == '-';
        int i = 0, res = 0;
        if ( pos || neg ) i++;
        while ( i < s.length() && Character.isDigit(s.charAt(i)) ) {
            long temp = (long)res*10 + s.charAt(i)-'0';
            res = res*10 + s.charAt(i)-'0';
            if ( temp != res ) return neg ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            i++;
        }
        return neg ? -res : res;
    }
}