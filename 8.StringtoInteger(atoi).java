class Solution {
    public int myAtoi(String s) {
        //trim
        s = s.trim();
        if ( s.isBlank() ) return 0;
        //negpos
        int ans = 0, i = 0;
        boolean pos = s.charAt(0) == '+';
        boolean neg = s.charAt(0) == '-';
        if ( pos || neg ) i ++;
        //loop
        while ( i < s.length() && Character.isDigit(s.charAt(i)) ){
            int digit = s.charAt(i) - '0';
            if ( ans > Integer.MAX_VALUE / 10 || (ans == Integer.MAX_VALUE / 10 && digit > Integer.MAX_VALUE % 10) ){
                return neg ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
            ans = ans*10 + digit;
            i++;
        }
        return neg ? -ans : ans;
    }
}