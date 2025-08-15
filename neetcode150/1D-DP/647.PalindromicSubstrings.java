class Solution {
    public int countSubstrings(String s) {
        boolean[][] dp = new boolean[s.length()][s.length()];
        int res = 0;
        for ( int i = dp.length-1; i >= 0; i-- ) {
            for ( int j = i; j < dp[0].length; j++ ) {
                if ( i == j ) dp[i][j] = true;
                else if ( i == j-1 ) dp[i][j] = s.charAt(i) == s.charAt(j);
                else dp[i][j] = s.charAt(i) == s.charAt(j) && dp[i+1][j-1];
                if ( dp[i][j] ) res++;
            }
        }
        return res;
    }
}