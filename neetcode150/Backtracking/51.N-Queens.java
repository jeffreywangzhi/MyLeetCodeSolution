class Solution {
    private HashSet<Integer> col = new HashSet<>();
    private HashSet<Integer> posDia = new HashSet<>();
    private HashSet<Integer> negDia = new HashSet<>();
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        dfs(n,res,new ArrayList<>(),0);
        return res;
    }
    private void dfs(int n, List<List<String>> res, List<String> cur, int idx) {
        if ( idx == n ) {res.add(new ArrayList<>(cur));return;}
        for ( int i = 0; i < n; i++ ) {
            if ( col.contains(i) || posDia.contains(i+idx) || negDia.contains(i-idx) ) continue;
            col.add(i);
            posDia.add(i+idx);
            negDia.add(i-idx);
            cur.add(construct(n,i));
            dfs(n,res,cur,idx+1);
            cur.remove(cur.size()-1);
            col.remove(i);
            posDia.remove(i+idx);
            negDia.remove(i-idx);
        }
    }
    private String construct(int n, int idx) {
        char[] row = new char[n];
        Arrays.fill(row,'.');
        row[idx] = 'Q';
        return new String(row);
    }
}