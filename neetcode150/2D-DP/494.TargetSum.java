class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        HashMap<String,Integer> dp = new HashMap<>();
        return dfs(nums,target,0,0,dp);
    }
    public int dfs(int[] nums, int target, int cur, int idx, HashMap<String,Integer> dp) {
        if ( idx == nums.length ) return cur == target ? 1 : 0;
        StringBuilder sb = new StringBuilder();
        sb.append(idx).append(",").append(cur);
        String key = sb.toString();
        if ( dp.containsKey(key) ) return dp.get(key);
        int ways = dfs(nums,target,cur+nums[idx],idx+1,dp) + dfs(nums,target,cur-nums[idx],idx+1,dp);
        dp.put(key,ways);
        return ways;
    }
}