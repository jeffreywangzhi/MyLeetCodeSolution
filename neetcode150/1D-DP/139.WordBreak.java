class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> set = new HashSet<>(wordDict);
        boolean[] memo = new boolean[s.length()];
        return dfs(s,set,memo,0);
    }
    public boolean dfs(String s, HashSet<String> set, boolean[] memo, int idx) {
        int i = idx;
        for ( ; i < s.length(); i++ ) {
            String sub = s.substring(idx,i+1);
            if ( !set.contains(sub) ) continue;
            if ( memo[i] ) continue;
            if ( dfs(s,set,memo,i+1) ) return true;
            else memo[i] = true;
        }
        return i == idx ? true : false;
    }
}