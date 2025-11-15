class Solution {
    public int[] searchRange(int[] nums, int target) {
        int idx = bs(nums,target);
        if ( idx == -1 ) return new int[]{-1,-1};
        int left = idx, right = idx;
        while ( left-1 >= 0 && nums[left-1] == target ) left--;
        while ( right+1 < nums.length && nums[right+1] == target ) right++;
        return new int[]{left,right};
    }
    public int bs(int[] nums, int target) {
        int start = 0, end = nums.length-1;
        while ( start <= end ) {
            int mid = start+(end-start)/2;
            if ( nums[mid] == target ) return mid;
            if ( nums[mid] < target ) start = mid+1;
            else end = mid-1;
        }
        return -1;
    }
}