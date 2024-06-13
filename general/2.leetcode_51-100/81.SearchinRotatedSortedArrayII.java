class Solution {
    public boolean search(int[] nums, int target) {
        int start = 0, end = nums.length-1, mid = 0;
        while ( start <= end ) {
            mid = ( start + end ) / 2;
            if ( nums[mid] == target ) return true;
            else if ( nums[mid] < nums[end] ) {
                if ( nums[mid] < target && nums[end] >= target ) {start=mid+1;}
                else {end = mid - 1;}
            }else if ( nums[end] < nums[mid] ) {
                if ( nums[mid] > target && nums[start] <= target ) {end=mid-1;}
                else {start = mid+1;}
            }else {
                end--;
            }
        }
        return false;
    }
}