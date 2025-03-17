class Solution {
    public int minCapability(int[] nums, int k) {
        int left = 0, right = 0;
        for ( int num : nums ) right = Math.max(right,num);
        while ( left < right ) {
            int mid = left+(right-left)/2;
            if ( canRob(nums,mid,k) ) right = mid;
            else left = mid+1;
        }
        return right;
    }
    private boolean canRob(int[] nums, int mid, int k){
        int cnt = 0, i = 0;
        while ( i < nums.length ) {
            if ( nums[i] <= mid ) {
                cnt++;
                i+=2;
            } else i++;
        }
        return cnt >= k;
    }
}s