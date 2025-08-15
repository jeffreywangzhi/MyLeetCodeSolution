class Solution {
    public int numDecodings(String s) {
        int[] dp = new int[s.length()+1];
        dp[0] = 1;
        for ( int i = 1; i < dp.length; i++ ) {
            char c = s.charAt(i-1);
            if ( c == '0' ) return 0;
            if ( i < s.length() && (c == '1' || c == '2') && s.charAt(i) == '0' ) dp[++i] = dp[i-2] == 0 ? 1 : dp[i-2];
            else if ( i == 1 ) dp[i] = 1;
            else {
                int tmp = Integer.valueOf(s.substring(i-2,i));
                dp[i] = tmp >= 10 && tmp <= 26 ? dp[i-1]+dp[i-2] : dp[i-1];
            }
        }
        return dp[dp.length-1];
    }
}