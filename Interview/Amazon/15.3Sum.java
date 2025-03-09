class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int p1 = 0, p2 = 0, p3 = 0;
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for ( ; p1 < nums.length-2; p1++ ) {
            if ( p1 != 0 && nums[p1] == nums[p1-1] ) continue;
            p2 = p1+1;
            p3 = nums.length-1;
            while ( p2 < p3 ) {
                if ( nums[p1] + nums[p2] + nums[p3] == 0 ) res.add(new ArrayList<>(Arrays.asList(nums[p1],nums[p2],nums[p3])));
                if ( nums[p1] + nums[p2] + nums[p3] < 0 ) {
                    p2++;
                    while ( nums[p2] == nums[p2-1] && p2 < p3 ) p2++;   
                }
                else {
                    p3--;
                    while ( nums[p3] == nums[p3+1] && p2 < p3 ) p3--;
                }
            }
        }
        return res;
    }
}