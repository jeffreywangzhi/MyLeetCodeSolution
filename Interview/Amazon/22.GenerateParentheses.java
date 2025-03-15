class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        dfs(n*2,0,0,new StringBuilder(),res);
        return res;
    }
    private void dfs(int n, int left, int right, StringBuilder cur, List<String> res) {
        if ( cur.length() > n || left < right ) return;
        if ( cur.length() == n && left == right ) res.add(cur.toString());
        cur.append('(');
        dfs(n,left+1,right,cur,res);
        cur.setCharAt(cur.length()-1,')');
        dfs(n,left,right+1,cur,res);
        cur.deleteCharAt(cur.length()-1);
    }
}