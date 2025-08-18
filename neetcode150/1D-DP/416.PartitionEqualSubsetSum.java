class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for ( int num : nums ) sum += num;
        if ( sum % 2 == 1 ) return false;
        HashSet<Integer> dp = new HashSet<>();
        dp.add(0);
        for ( int i = nums.length-1; i >= 0; i-- ) {
            HashSet<Integer> tmp = new HashSet<>(dp);
            for ( Integer in : dp ) {
                tmp.add(in+nums[i]);
                tmp.add(nums[i]);
            }
            dp = tmp;
        }
        return dp.contains(sum/2);
    }
}