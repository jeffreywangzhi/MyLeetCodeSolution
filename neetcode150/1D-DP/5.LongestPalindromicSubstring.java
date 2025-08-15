class Solution {
    public String longestPalindrome(String s) {
        boolean[][] dp = new boolean[s.length()][s.length()];
        int res = 1; String r = String.valueOf(s.charAt(0));
        for ( int i = s.length()-1; i >= 0; i-- ) {
            for ( int j = i; j < dp[0].length; j++ ) {
                if ( i == j ) dp[i][j] = true;
                else if ( i == j-1 ) dp[i][j] = s.charAt(i) == s.charAt(j);
                else if ( s.charAt(i) == s.charAt(j) && dp[i+1][j-1] == true ) dp[i][j] = true;
                if ( dp[i][j] == true && j-i+1 > res ) {
                    res = j-i+1;
                    r = s.substring(i,j+1);
                }
            }
        }
        return r;
    }
}