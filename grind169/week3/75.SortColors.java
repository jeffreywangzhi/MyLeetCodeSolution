class Solution {
    public void sortColors(int[] nums) {
        int red = 0;
        int blue = nums.length-1;
        for ( int i = 0; i <= blue; i++ ) {
            if ( nums[i] == 0 ) {
                swap(nums,i,red);
                red++;
            } else if ( nums[i] == 2 ) {
                swap(nums,i,blue);
                blue--;
                i--;
            }
        }
    }
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}