class Solution {
    public void nextPermutation(int[] nums) {
        if ( nums.length < 2 ) return;
        int swap = Integer.MAX_VALUE;
        int swapx = -1;
        for ( int i = nums.length - 1; i >= 1; i-- ) {
            if ( nums[i] > nums[i-1] ) {
                for ( int j = nums.length - 1; j > i-1; j-- ) {
                    if ( nums[j] < swap && nums[j] > nums[i-1] ) {
                        swap = nums[j];
                        swapx = j;
                    }
                }
                swap(nums, i-1, swapx);
                reverse(nums, i);
                return;
            }
        }
        reverse(nums, 0);
    }
    private void reverse(int[] nums, int index) {
        for ( int i = index, j = nums.length - 1; i < j; i++, j-- ) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }
    private void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}