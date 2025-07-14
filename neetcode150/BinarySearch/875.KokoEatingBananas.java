class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int start = 1, end = (int)1e9;
        while ( start < end ) {
            int mid = start+(end-start)/2;
            if ( helper(piles,h,mid) ) end = mid;
            else start = mid+1;
        }
        return end;
    }
    private boolean helper(int[] piles, int h, int num) {
        int cur = 0;
        for ( int i = 0; i < piles.length; i++ ) {
            cur += piles[i]/num;
            if ( piles[i]%num != 0 ) cur++;
            if ( cur > h ) return false;
        }
        return true;
    }
}