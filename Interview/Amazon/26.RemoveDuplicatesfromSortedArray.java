class Solution {
    public int removeDuplicates(int[] nums) {
        int unique = 0;
        for ( int i = 1; i < nums.length; i++ ) {
            if ( nums[i] != nums[unique] ) nums[++unique] = nums[i];
        }
        return unique+1;
    }
}