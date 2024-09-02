class Solution {
    public boolean canJump(int[] nums) {
        int reach = 0, last = nums.length-1;
        for ( int i = 0; i <= last; i++ ) {
            if ( i > reach || reach >= last ) break;
            reach = Math.max(reach,i+nums[i]);
        }
        return reach >= last;
    }
}