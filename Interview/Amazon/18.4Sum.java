class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for ( int i = 0; i < nums.length-3; i++ ) {
            if ( i > 0 && nums[i] == nums[i-1] ) continue;
            for ( int j = i+1; j < nums.length-2; j++ ) {
                if ( j > i+1 && nums[j] == nums[j-1] ) continue;
                int k = j+1, l = nums.length-1;
                while ( k < l ) {
                    long cur = (long) nums[i] + nums[j] + nums[k] + nums[l];
                    if ( cur == target ) {
                        res.add(new ArrayList<>(Arrays.asList(nums[i],nums[j],nums[k],nums[l])));
                        k++;
                        while ( nums[k] == nums[k-1] && k < l ) k++;
                    }
                    else if ( cur < target ) k++;
                    else l--;
                }
            }
        }
        return res;
    }
}