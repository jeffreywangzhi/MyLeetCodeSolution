class Solution {
    public int removeDuplicates(int[] nums) {
        if ( nums.length == 1 ) return 1;
        int i = 0, j = 1;
        while ( j < nums.length ) {
            if ( nums[j] == nums[i] ) j++;
            else {
                i++;
                nums[i] = nums[j];
                j++;
            }
        }
        return i + 1;
    }
}