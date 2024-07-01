class Solution {
    public int missingNumber(int[] nums) {
        Arrays.sort(nums);
        return bs(0,nums.length,nums);
    }
    private int bs(int start, int end, int[] nums) {
        if ( start >= end ) return end;
        int mid = start + (end-start) / 2;
        return nums[mid] > mid ? bs(start,mid,nums) : bs(mid+1,end,nums);
    }
}