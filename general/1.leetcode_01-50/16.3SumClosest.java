class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.stream(nums).distinct().toArray();
        Arrays.sort(nums);
        int res = Integer.MAX_VALUE;
        for ( int i = 0; i < nums.length - 2; i++) {
            int j = i + 1, k = nums.length - 1;
            while ( j < k ) {
                if ( Math.abs(nums[i] + nums[j] + nums[k] - target) < Math.abs(res - target) ) {
                    res = nums[i] + nums[j] + nums[k];
                    if ( nums[i] + nums[j] + nums[k] < target ) j++;
                    else k--;
                }else if ( nums[i] + nums[j] + nums[k] < target ) {
                    j++;
                }else if ( nums[i] + nums[j] + nums[k] > target ) {
                    k--;
                }else return nums[i] + nums[j] + nums[k];
            }
        }
        return res;
    }
}