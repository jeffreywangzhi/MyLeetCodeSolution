class Solution {
    public int maxProduct(int[] nums) {
        int min = nums[0], max = nums[0], res = nums[0];
        for ( int i = 1; i < nums.length; i++ ) {
            if ( nums[i] < 0 ) {
                int temp = min;
                min = max;
                max = temp;
            }
            min = Math.min(nums[i],min*nums[i]);
            max = Math.max(nums[i],max*nums[i]);
            res = Math.max(res,max);
        }
        return res;
    }
}