class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] fwd = new int[nums.length];
        fwd[0] = nums[0];
        int[] bwd = new int[nums.length];
        bwd[bwd.length-1] = nums[nums.length-1];
        for ( int i = 1; i < fwd.length; i++ ) {
            fwd[i] = nums[i] * fwd[i-1];
        }
        for ( int i = bwd.length-2; i >= 0; i-- ) {
            bwd[i] = nums[i] * bwd[i+1];
        }
        int[] res = new int[nums.length];
        res[0] = bwd[1]; res[res.length-1] = fwd[fwd.length-2];
        for ( int i = 1; i < res.length-1; i++ ) {
            res[i] = fwd[i-1] * bwd[i+1];
        }
        return res;
    }
}