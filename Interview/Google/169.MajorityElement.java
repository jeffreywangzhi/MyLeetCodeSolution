class Solution {
    public int majorityElement(int[] nums) {
        int cur = nums[0], cnt = 0;
        for ( int i = 0; i < nums.length; i++ ) {
            if ( nums[i] == cur ) cnt++;
            else if ( --cnt == 0 ) cur = nums[i+1];
        }
        return cur;
    }
}