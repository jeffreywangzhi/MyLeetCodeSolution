class Solution {
    public List<List<Integer>> permute(int[] nums) {
        int[] visited = new int[nums.length];
        List<Integer> cur = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        dfs(nums, 0, visited, cur, res);
        return res;
    }
    private void dfs(int[] nums, int level, int[] visited, List<Integer> cur, List<List<Integer>> res) {
        if ( level == nums.length ) { res.add(new ArrayList<>(cur)); return; }
        for ( int i = 0; i < nums.length; i++ ) {
            if ( visited[i] == 1 ) continue;
            visited[i] = 1;
            cur.add(nums[i]);
            dfs(nums, level+1, visited, cur, res);
            cur.remove(cur.size()-1);
            visited[i] = 0;
        }
    }
}