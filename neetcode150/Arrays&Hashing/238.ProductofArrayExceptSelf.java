class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        int pre = 1;
        res[0] = pre;
        for ( int i = 0; i < nums.length-1; i++ ) {
            pre *= nums[i];
            res[i+1] = pre;
        }
        pre = 1;
        for ( int i = nums.length-1; i >= 1; i-- ) {
            pre *= nums[i];
            res[i-1] = res[i-1]*pre;
        }
        return res;
    }
}