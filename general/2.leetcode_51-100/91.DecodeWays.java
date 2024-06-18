class Solution {
    public int numDecodings(String s) {
        if ( s.charAt(0) == '0' ) return 0;
        int[] dp = new int[s.length()+1];
        dp[0] = 1;
        dp[1] = 1;
        for ( int i = 1; i < s.length(); i++ ) {
            if ( s.charAt(i) == '0' && s.charAt(i-1) == '0' || s.charAt(i) == '0' && s.charAt(i-1) - '0' > 2) {return 0;}
            else if ( s.charAt(i) == '0' ) {dp[i+1] = dp[i-1];}
            else if ( s.charAt(i-1) - '0' >= 1 && Integer.valueOf(s.charAt(i-1) + "" + s.charAt(i)) <= 26 ) {dp[i+1] = dp[i] + dp[i-1];}
            else {dp[i+1] = dp[i];}
        }
        return dp[dp.length-1];
    }
}