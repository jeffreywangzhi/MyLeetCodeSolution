class Solution {
    public void nextPermutation(int[] nums) {
        for ( int i = nums.length-2; i >= 0; i-- ) {
            if ( nums[i] < nums[i+1] ) {
                int j = nums.length-1;
                while ( nums[i] >= nums[j] ) j--;
                swap(nums,i,j);
                reverse(nums,i+1);
                return;
            }
        }
        reverse(nums,0);
        return;
    }
    public void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
    public void reverse(int[] nums, int idx) {
        int start = idx, end = nums.length-1;
        while ( start < end ) {
            int tmp = nums[start];
            nums[start] = nums[end];
            nums[end] = tmp;
            start++;end--;
        }
    }
}