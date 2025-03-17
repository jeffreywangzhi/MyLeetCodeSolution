class Solution {
    public int maximumCandies(int[] candies, long k) {
        long max = 0, sum = 0;
        for ( int can : candies ) {
            max = Math.max(max,can);
            sum += can;
        }
        if ( sum <= k ) return 0;
        int start = 1, end = (int) max;
        while ( start <= end ) {
            int mid = start+(end-start)/2;
            if ( helper(candies,mid,k) ) start = mid+1;
            else end = mid-1;
        }
        return end;
    }
    private boolean helper(int[] candies, long m, long k) {
        long res = 0;
        for ( int can : candies ) {
            res += can/m;
            if ( res >= k ) break;
        }
        return res >= k;
    }
}