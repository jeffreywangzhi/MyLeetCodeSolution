class Solution {
    public void nextPermutation(int[] nums) {
        for ( int i = nums.length-2; i >= 0; i-- ) {
            if ( nums[i] < nums[i+1] ) {
                int j = nums.length-1;
                while ( nums[j] <= nums[i] ) j--;
                swap(nums,i,j);
                reverse(nums,i+1);
                return;
            }
        }
        reverse(nums,0);
    }
    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
    private void reverse(int[] nums, int i) {
        for ( int j = nums.length-1; i < j; i++, j-- ) {
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }
    }
}