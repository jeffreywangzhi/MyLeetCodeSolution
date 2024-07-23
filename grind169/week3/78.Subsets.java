class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        helper(nums,res,new ArrayList<>(),0);
        return res;
    }
    private void helper(int[] nums, List<List<Integer>> res, List<Integer> cur, int level) {
        if ( !res.contains(cur) ) res.add(new ArrayList<>(cur));
        for ( int i = level; i < nums.length; i++ ) {
            cur.add(nums[i]);
            helper(nums,res,cur,i+1);
            cur.remove(cur.size()-1);
        }
    }
}