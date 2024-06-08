class Solution {
    public int[] searchRange(int[] nums, int target) {
        if (nums.length < 1) return new int[] {-1, -1};
        int startx = bs(nums, target, 0, nums.length - 1);
        if (startx > nums.length - 1 || nums[startx] != target) return new int[] {-1, -1};
        return new int[] {startx, bs(nums, target + 1, 0, nums.length - 1) - 1};
    }

    private int bs(int[] nums, int target, int start, int end) {
        while (start <= end) {
            int mid = (start + end) / 2;
            if (nums[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return start;
    }
}
