class Solution {
    public int firstMissingPositive(int[] nums) {
        for ( int i = 0; i < nums.length; i++ ) {
            while ( nums[i] > 0 && nums[i] <= nums.length && nums[i] != i+1 && nums[i] != nums[nums[i]-1]) {
                swap(nums,i,nums[i]-1);
            }
        }
        for ( int i = 0; i < nums.length; i++ ) {
            if ( i+1 != nums[i] ) return i+1;
        }
        return nums.length+1;
    }
    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}