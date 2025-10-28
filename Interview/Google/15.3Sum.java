class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for ( int i = 0; i < nums.length-2; i++ ) {
            if ( i != 0 && nums[i] == nums[i-1] ) continue;
            int j = i+1, k = nums.length-1;
            while ( j < k ) {
                int cur = nums[i]+nums[j]+nums[k];
                if ( cur == 0 ) res.add(new ArrayList<>(Arrays.asList(nums[i],nums[j],nums[k])));
                if ( cur <= 0 ) {
                    while ( j+1 < nums.length && nums[j] == nums[j+1] ) j++;
                    j++;
                } else {
                    while ( k-1 >= 0 && nums[k] == nums[k-1] ) k--;
                    k--;
                }
            }
        }
        return res;
    }
}