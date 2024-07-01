class Solution {
    public void moveZeroes(int[] nums) {
        for ( int i = 0, j = 0; j < nums.length; j++ ) {
            if ( nums[j] != 0 ) {
                int temp = nums[i];
                nums[i++] = nums[j];
                nums[j] = temp;
            }
        }
    }
}