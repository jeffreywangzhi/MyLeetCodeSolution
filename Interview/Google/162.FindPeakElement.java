class Solution {
    public int findPeakElement(int[] nums) {
        int start = 0, end = nums.length-1;
        while ( start <= end ) {
            int mid = start+(end-start)/2;
            if (( mid-1 < 0 || nums[mid-1] < nums[mid] ) && ( mid+1 >= nums.length || nums[mid+1] < nums[mid] )) return mid;
            if ( mid-1 < 0 || nums[mid-1] < nums[mid] ) start = mid+1;
            else end = mid-1;
        }
        return -1;
    }
}