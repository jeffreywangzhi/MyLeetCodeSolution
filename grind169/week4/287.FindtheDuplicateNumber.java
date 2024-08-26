class Solution {
    public int findDuplicate(int[] nums) {
        int start = 1, end = nums.length;
        while ( start < end ) {
            int mid = start + (end-start) / 2, cnt = 0;
            for ( int num : nums ) {
                if ( num <= mid ) cnt++;
            }
            if ( cnt <= mid ) start = mid+1;
            else end = mid;
        }
        return end;
    }
}