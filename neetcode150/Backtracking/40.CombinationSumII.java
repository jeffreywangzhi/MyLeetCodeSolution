class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();
        dfs(candidates,target,0,new ArrayList<>(),res);
        return res;
    }
    private void dfs(int[] candidates, int target, int idx, List<Integer> cur, List<List<Integer>> res) {
        if ( target < 0 ) return;
        if ( target == 0 ) {res.add(new ArrayList<>(cur));return;}
        for ( int i = idx; i < candidates.length; i++ ) {
            if ( i != idx && candidates[i] == candidates[i-1] ) continue;
            cur.add(candidates[i]);
            dfs(candidates,target-candidates[i],i+1,cur,res);
            cur.remove(cur.size()-1);
        }
    }
}