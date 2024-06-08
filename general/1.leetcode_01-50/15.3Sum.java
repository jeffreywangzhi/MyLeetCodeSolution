class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        for ( int i = 0 ; i < nums.length - 2 ; i ++ ) {
            if ( i != 0 && nums[i] == nums[i-1] ) continue;
            int j = i + 1, k = nums.length - 1; 
            while ( j < k ) {
                if ( nums[i] + nums[j] + nums[k] == 0 ) {
                    list.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    j++;
                    while (nums[j] == nums[j-1] && j < k) {
                        j++;
                    }
                } else if ( nums[i] + nums[j] + nums[k] > 0 ) {
                    k--;
                } else if ( nums[i] + nums[j] + nums[k] < 0 ) {
                    j++;
                }
            }
        }
        return list;
    }
}