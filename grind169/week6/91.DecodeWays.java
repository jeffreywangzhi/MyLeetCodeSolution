class Solution {
    public int numDecodings(String s) {
        if ( s.charAt(0) == '0' ) return 0;
        int[] dp = new int[s.length()+1];
        dp[0] = 1; dp[1] = 1;
        for ( int i = 1; i < s.length(); i++ ) {
            String sub = s.substring(i-1,i+1);
            if ( (s.charAt(i-1) == '0' && s.charAt(i) == '0') || (s.charAt(i) == '0' && s.charAt(i-1)-'0' > 2 ) ) return 0;
            if ( s.charAt(i) == '0' ) dp[i+1] = dp[i-1];
            else if ( sub.charAt(0) == '0' || Integer.parseInt(sub) > 26) dp[i+1] = dp[i];
            else dp[i+1] = dp[i]+dp[i-1];
        }
        return dp[dp.length-1];
    }
}