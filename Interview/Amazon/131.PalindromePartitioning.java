class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        boolean[][] dp = new boolean[s.length()][s.length()];
        for ( int i = 0; i < s.length(); i++ ) {
            for ( int j = 0; j <= i; j++ ) {
                if ( s.charAt(i) == s.charAt(j) && (i-j <= 2 || dp[j+1][i-1]) ) dp[j][i] = true;
            }
        }
        dfs(s,0,dp,new ArrayList<>(),res);
        return res;
    }
    private void dfs(String s, int idx, boolean[][] dp, List<String> cur, List<List<String>> res) {
        if ( idx >= s.length() ) {
            res.add(new ArrayList<>(cur));
            return;
        }
        for ( int i = idx; i < s.length(); i++ ) {
            if ( dp[idx][i] ) {
                cur.add(s.substring(idx,i+1));
                dfs(s,i+1,dp,cur,res);
                cur.remove(cur.size()-1);
            }
        }
    }
}