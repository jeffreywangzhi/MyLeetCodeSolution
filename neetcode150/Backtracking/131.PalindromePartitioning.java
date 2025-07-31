class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        dfs(s,0,new ArrayList<>(),res);
        return res;
    }
    private boolean isPalind(String s) {
        int p1 = 0, p2 = s.length()-1;
        while ( p1 < p2 ) {
            if ( s.charAt(p1) != s.charAt(p2) ) return false;
            p1++;p2--;
        }
        return true;
    }
    private void dfs(String s, int idx, List<String> cur, List<List<String>> res) {
        if ( idx == s.length() ) {res.add(new ArrayList<>(cur));return;}
        for ( int i = idx+1; i <= s.length(); i++ ) {
            String tmp = s.substring(idx,i);
            if ( isPalind(tmp) ) {
                cur.add(tmp);
                dfs(s,i,cur,res);
                cur.remove(cur.size()-1);
            } else continue;
        }
    }
}