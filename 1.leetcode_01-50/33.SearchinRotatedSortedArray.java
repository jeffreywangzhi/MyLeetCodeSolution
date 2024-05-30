class Solution {
    public int search(int[] nums, int target) {
        return bs(nums, target, 0, nums.length-1);
    }
    private int bs(int[] nums, int target, int start, int end) {
        if ( start > end ) return -1;
        int mid = ( start + end ) / 2;
        if ( nums[mid] == target ) return mid;
        else if ( nums[mid] < nums[end] ) {
            if ( nums[mid] < target && target <= nums[end] ) 
                return bs(nums, target, mid+1, end);
            else return bs(nums, target, start, mid-1);
        }else {
            if ( nums[start] <= target && target < nums[mid] ) 
                return bs(nums, target, start, mid-1);
            else return bs(nums, target, mid+1, end);
        }
    }
}