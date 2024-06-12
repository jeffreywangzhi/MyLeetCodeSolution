class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> cur = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());
        dfs(nums, 0, cur, res);
        return res;
    }
    private void dfs(int[] nums, int start, List<Integer> cur, List<List<Integer>> res) {
        for ( int i = start; i < nums.length; i++ ) {
            cur.add(nums[i]);
            if ( !res.contains(cur) ) res.add(new ArrayList<>(cur));
            dfs(nums, i+1, cur, res);
            cur.remove(cur.size()-1);
        }
    }
}