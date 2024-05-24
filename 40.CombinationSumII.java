class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        dfs(candidates, target, 0, cur, res);
        return res;
    }
    private void dfs(int[] candidates, int target, int start, List<Integer> cur, List<List<Integer>> res) {
        if ( target < 0 ) return;
        if ( target == 0 ) { res.add(new ArrayList<>(cur)); return; }
        for ( int i = start; i < candidates.length; i++ ) {
            if (i != start && candidates[i] == candidates[i - 1]) continue; //重複數字
            cur.add(candidates[i]);
            dfs(candidates, target-candidates[i], i+1, cur, res); //當前數字
            cur.remove(cur.size()-1);
        }
    }
}