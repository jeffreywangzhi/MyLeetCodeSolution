class Solution {
    public List<List<Integer>> combine(int n, int k) {
        int[] list = new int[n];
        for ( int i = 0; i < n; i++ ) list[i] = i+1;
        List<Integer> cur = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        dfs(k, list, 0, cur, res);
        return res;
    }
    private void dfs(int k, int[] list, int start, List<Integer> cur, List<List<Integer>> res) {
        if ( cur.size() == k ) {res.add(new ArrayList<>(cur)); return;}
        for ( int i = start; i < list.length; i++ ) {
            cur.add(list[i]);
            dfs(k, list, i+1, cur, res);
            cur.remove(cur.size()-1);
        }
    }
}