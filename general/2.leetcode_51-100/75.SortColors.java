class Solution {
    public void sortColors(int[] nums) {
        int red = 0, blue = nums.length - 1;
        for ( int i = 0; i <= blue; i++ ) {
            if ( nums[i] == 0 ) {swap(nums, i, red); red++;}
            else if ( nums[i] == 2 ) {swap(nums, i--, blue); blue--;}
        }
    }
    private void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}