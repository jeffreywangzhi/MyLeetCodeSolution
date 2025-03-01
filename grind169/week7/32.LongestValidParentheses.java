class Solution {
    public int longestValidParentheses(String s) {
        int dp[] = new int[s.length()+1];
        int res = 0;
        for ( int i = 1; i <= s.length(); i++ ) {
            int j = i-dp[i-1]-2;
            if ( s.charAt(i-1) == '(' || j < 0 || s.charAt(j) == ')' ) {
                dp[i] = 0;
            } else {
                dp[i] = dp[i-1]+dp[j]+2;
                res = Math.max(res,dp[i]);
            }
        }
        return res;
    }
}