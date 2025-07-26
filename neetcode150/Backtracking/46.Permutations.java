class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(nums,new ArrayList<>(),res,new int[nums.length]);
        return res;
    }
    private void dfs(int[] nums, List<Integer> cur, List<List<Integer>> res, int[] visited) {
        if ( cur.size() == nums.length ) {res.add(new ArrayList<>(cur));return;}
        for ( int i = 0; i < nums.length; i++ ) {
            if ( visited[i] == 1 ) continue;
            cur.add(nums[i]);
            visited[i] = 1;
            dfs(nums,cur,res,visited);
            visited[i] = 0;
            cur.remove(cur.size()-1);
        }
    }
}