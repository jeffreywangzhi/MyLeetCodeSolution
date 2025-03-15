class Solution {
    public int longestOnes(int[] nums, int k) {
        int[] arr = new int[2];
        int i = 0, j = 0, max = 0;
        for ( ; j < nums.length; j++ ) {
            arr[nums[j]]++;
            if ( arr[0] <= k ) max = Math.max(max,j-i+1);
            while ( arr[0] > k ) arr[nums[i++]]--;
        }
        return max;
    }
}