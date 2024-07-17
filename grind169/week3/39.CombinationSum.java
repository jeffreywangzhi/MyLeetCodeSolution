class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<Integer> cur = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        for ( int i = 0; i < candidates.length; i++ ) {
            helper(candidates,new ArrayList<>(),i,0,target,res);
        }
        return res;
    }
    private void helper(int[] candidates, List<Integer> cur, int level, int sum, int target, List<List<Integer>> res) {
        cur.add(candidates[level]);
        sum += candidates[level];
        if ( sum == target ) res.add(new ArrayList<>(cur));
        else if ( sum > target ) return;
        for ( int i = level; i < candidates.length; i++ ) {
            if ( sum + candidates[i] > target ) break;
            helper(candidates,cur,i,sum,target,res);
            cur.remove(cur.size()-1);
        }
    }
}