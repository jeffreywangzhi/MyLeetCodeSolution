class Solution {
    public int searchInsert(int[] nums, int target) {
        return bns(nums, target, 0, nums.length - 1);
    }
    private int bns(int[] nums, int target, int start, int end) {
        int mid = ( start + end ) / 2;
        if ( nums[mid] == target ) return mid;
        else if ( target < nums[mid] )
            return start < mid ? bns(nums, target, start, mid-1) : start;
        else
            return end > mid ? bns(nums, target, mid+1, end) : end+1;
    }
}