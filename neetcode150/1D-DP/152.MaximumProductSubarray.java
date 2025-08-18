class Solution {
    public int maxProduct(int[] nums) {
        int res = Integer.MIN_VALUE, curMax = 1, curMin = 1;
        for ( int num : nums ) {
            int tmp = num*curMax;
            curMax = Math.max(tmp,Math.max(num*curMin,num));
            curMin = Math.min(num*curMin,Math.min(tmp,num));
            res = Math.max(res,curMax);
        }
        return res;
    }
}