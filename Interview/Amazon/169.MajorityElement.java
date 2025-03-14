class Solution {
    public int majorityElement(int[] nums) {
        int can = nums[0], cnt = 1;
        for ( int i = 1; i < nums.length; i++ ) {
            if ( cnt == 0 ) {
                can = nums[i];
                cnt = 1;
                continue;
            }
            if ( can == nums[i] ) cnt++;
            else cnt--;
        }
        return can;
    }
}