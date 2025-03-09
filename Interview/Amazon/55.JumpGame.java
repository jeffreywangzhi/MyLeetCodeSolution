class Solution {
    public boolean canJump(int[] nums) {
        int reach = nums[0], idx = 0;
        while ( idx <= reach ) {
            reach = Math.max(reach,idx+nums[idx]);
            if ( reach >= nums.length-1 ) return true;
            idx++;
        }
        return false;
    }
}