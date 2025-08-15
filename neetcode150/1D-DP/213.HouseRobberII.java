class Solution {
    public int rob(int[] nums) {
        if ( nums.length == 1 ) return nums[0];
        int[] nums1 = Arrays.copyOfRange(nums,0,nums.length-1);
        int[] nums2 = Arrays.copyOfRange(nums,1,nums.length);
        return Math.max(robFunc(nums1),robFunc(nums2));
    }
    public int robFunc(int[] nums) {
        int[] res = new int[nums.length+2];
        res[2] = nums[0];
        for ( int i = 1; i < nums.length; i++ ) res[i+2] = Math.max(Math.max(res[i-1]+nums[i],res[i]+nums[i]),res[i+1]);
        return res[res.length-1];
    }
}