class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<Integer> cur = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        dfs(nums, 0, cur, res);
        return res;
    }
    private void dfs(int[] nums, int idx, List<Integer> cur, List<List<Integer>> res) {
        res.add(new ArrayList<>(cur));
        for ( int i = idx; i < nums.length; i++ ) {
            if( i != idx && nums[i] == nums[i-1] ) continue;
            cur.add(nums[i]);
            dfs(nums, i+1, cur, res);
            cur.remove(cur.size()-1);
        }
    }
}