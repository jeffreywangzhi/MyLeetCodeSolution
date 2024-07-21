class Solution {
    private HashSet<String> memo = new HashSet<>();
    public boolean wordBreak(String s, List<String> wordDict) {
        return helper(s,wordDict);
    }
    private boolean helper(String s, List<String> wordDict) {
        if ( s.length() == 0 ) return true;
        if ( memo.contains(s) ) return false;
        for ( int i = 1; i <= s.length(); i++ ) {
            String pre = s.substring(0,i);
            if ( wordDict.contains(pre) ) {
                if ( helper(s.substring(i),wordDict) ) return true;
            }
        }
        memo.add(s);
        return false;
    }
}
// better solution needed