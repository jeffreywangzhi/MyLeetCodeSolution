class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());
        helper(nums,res,0,new ArrayList<>());
        return res;
    }
    private void helper(int[] nums, List<List<Integer>> res, int idx, List<Integer> cur) {
        for ( int i = idx; i < nums.length; i++ ) {
            cur.add(nums[i]);
            res.add(new ArrayList<>(cur));
            helper(nums,res,i+1,cur);
            cur.remove(cur.size()-1);
        }
    }
}