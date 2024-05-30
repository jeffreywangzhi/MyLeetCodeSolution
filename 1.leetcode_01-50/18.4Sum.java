class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<>();
        for ( int i = 0; i < nums.length - 3; i++ ) {
            if ( i != 0 && nums[i] == nums[i-1] ) continue;
            for ( int j = i + 1; j < nums.length - 2; j++ ) {
                if ( j != i + 1 && nums[j] == nums[j-1] ) continue;
                int k = j + 1, l = nums.length - 1; 
                while ( k < l ) {
                    if ( (long)nums[i] + (long)nums[j] + (long)nums[k] + (long)nums[l] == (long)target) {
                        list.add(Arrays.asList(nums[i], nums[j], nums[k], nums[l]));
                        k++;
                        while ( nums[k] == nums[k-1] && k < l ) {
                            k++;
                        }
                    } else if ( (long)nums[i] + (long)nums[j] + (long)nums[k] + (long)nums[l] > (long)target ) {
                        l--;
                    } else if ( (long)nums[i] + (long)nums[j] + (long)nums[k] + (long)nums[l] < (long)target ) {
                        k++;
                    }
                }
            }
        }
        return list;
    }
}