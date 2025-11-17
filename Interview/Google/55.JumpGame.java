class Solution {
    public boolean canJump(int[] nums) {
        int cur = 0, max = 0;
        for ( int i = 0; i <= cur && i < nums.length; i++ ) {
            max = Math.max(max,i+nums[i]);
            if ( i == cur ) cur = max;
        }
        return cur >= nums.length-1;
    }
}