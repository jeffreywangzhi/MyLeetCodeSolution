class Solution {
    public int countValidSelections(int[] nums) {
        int sum = 0, res = 0;
        for ( int n : nums ) sum += n;
        int left = 0, right = sum;
        for ( int i = 0; i < nums.length; i++ ) {
            if ( nums[i] != 0 ) {
                left += nums[i];
                right -= nums[i];
            } else {
                int diff = Math.abs(left-right);
                if ( diff == 0 ) res += 2;
                else if ( diff == 1 ) res++;
            }
        }
        return res;
    }
}