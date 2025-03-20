class Solution {
    public int triangularSum(int[] nums) {
        int level = nums.length;
        while ( level > 0 ) {
            for ( int i = 0; i < level-1; i++ ) nums[i] = (nums[i]+nums[i+1])%10;
            level--;
        }
        return nums[0];
    }
}