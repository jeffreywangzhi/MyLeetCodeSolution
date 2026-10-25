class Solution {
    public boolean kLengthApart(int[] nums, int k) {
        int d = k;
        for ( int i = 0; i < nums.length; i++ ) {
            if ( nums[i] == 0 ) d++;
            else if ( d < k ) return false;
            else d = 0;
        }
        return true;
    }
}