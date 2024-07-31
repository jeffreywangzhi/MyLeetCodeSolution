class Solution {
    public void nextPermutation(int[] nums) {
        for ( int i = nums.length-2; i >= 0; i-- ) {
            if ( nums[i] < nums[i+1] ) {
                int j = nums.length-1;
                for ( ; j >= i; j-- ) if ( nums[i] < nums[j] ) break;
                swap(nums,i,j);
                reverse(nums,i+1,nums.length-1);
                return;
            }
        }
        Arrays.sort(nums);
        return;
    }
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    private void reverse(int[] nums, int a, int b) {
        for ( int i = a, j = b; i <= (a+b)/2; i++, j-- ) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }
}