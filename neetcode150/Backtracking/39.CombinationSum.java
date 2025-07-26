class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        int[] sum = new int[1];
        List<List<Integer>> res = new ArrayList<>();
        dfs(candidates,sum,target,0,new ArrayList<>(),res);
        return res;
    }
    private void dfs(int[] candidates, int[] sum, int target, int idx, List<Integer> cur, List<List<Integer>> res) {
        for ( int i = idx; i < candidates.length; i++ ) {
            int num = candidates[i];
            if ( sum[0] + num > target ) {return;}
            else if ( sum[0] + num == target ) {
                cur.add(num);
                res.add(new ArrayList<>(cur));
                cur.remove(cur.size()-1);
                return;
            } else if ( sum[0] + num < target ) {
                cur.add(num);
                sum[0] += num;
                dfs(candidates,sum,target,i,cur,res);
                cur.remove(cur.size()-1);
                sum[0] -= num;
            }
        }
    }
}