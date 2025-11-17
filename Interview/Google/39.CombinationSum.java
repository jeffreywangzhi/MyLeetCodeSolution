class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(0,candidates,target,new ArrayList<>(),res);
        return res;
    }
    public void dfs(int idx, int[] candidates, int target, List<Integer> cur, List<List<Integer>> res) {
        if ( target == 0 ) {res.add(new ArrayList<>(cur));return;}
        if ( target < 0 || idx >= candidates.length ) return;
        cur.add(candidates[idx]);
        dfs(idx,candidates,target-candidates[idx],cur,res);
        cur.remove(cur.size()-1);
        dfs(idx+1,candidates,target,cur,res);
    }
}