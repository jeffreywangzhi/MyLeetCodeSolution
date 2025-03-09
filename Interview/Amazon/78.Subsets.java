class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());
        dfs(nums,0,new ArrayList<>(),res);
        return res;
    }
    private void dfs(int[] nums, int idx, List<Integer> cur, List<List<Integer>> res) {
        for ( int i = idx; i < nums.length; i++ ) {
            cur.add(nums[i]);
            res.add(new ArrayList<>(cur));
            dfs(nums,i+1,cur,res);
            cur.remove(cur.size()-1);
        }
    }
}