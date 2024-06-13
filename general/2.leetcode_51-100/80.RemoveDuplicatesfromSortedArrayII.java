class Solution {
    public int removeDuplicates(int[] nums) {
        int i = 0, j = 1, cnt = 0;
        while ( j < nums.length ) {
            if ( nums[i] == nums[j] && cnt < 1 ) {
                cnt++;
                nums[++i] = nums[j++];
            } else if ( nums[i] == nums[j] ) {
                j++;
            } else {
                nums[++i] = nums[j++];
                cnt = 0;
            }
        }
        return i+1;
    }
}