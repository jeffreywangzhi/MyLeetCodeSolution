class Solution {
    public int jump(int[] nums) {
        int res = 0, cur = 0, next = 0;
        for ( int i = 0; i < nums.length-1; i++ ) {
            next = Math.max(next,i+nums[i]);
            if ( i == cur ) {
                res++;
                cur = next;
                if ( cur >= nums.length-1 ) break;
            }
        }
        return res;
    }
}