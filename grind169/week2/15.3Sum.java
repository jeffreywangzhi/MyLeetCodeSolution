class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for ( int i = 0; i < nums.length-2; i++ ) {
            if ( i != 0 && nums[i] == nums[i-1] ) continue;
            int j = i+1, k = nums.length-1;
            while ( j < k ) {
                if ( nums[i] + nums[j] + nums[k] == 0 ) {
                    res.add(Arrays.asList(nums[i],nums[j],nums[k]));
                    while ( j < k ) {
                        if ( nums[j] == nums[j+1] ) j++;
                        else if ( nums[k] == nums[k-1] ) k--;
                        else break;
                    }
                    j++;k--;
                }
                else if ( nums[i] + nums[j] + nums[k] < 0 ) j++;
                else if ( nums[i] + nums[j] + nums[k] > 0 ) k--;
            }
        }
        return res;
    }
}