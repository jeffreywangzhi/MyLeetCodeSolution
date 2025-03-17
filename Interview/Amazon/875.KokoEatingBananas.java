class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int start = 1, end = 1000000000;
        while ( start < end ) {
            int mid = start+(end-start)/2;
            int cnt = 0;
            for ( int pile : piles ) cnt += (pile%mid==0?pile/mid:(pile/mid)+1);
            if ( cnt > h ) start = mid+1;
            else end = mid;
        }
        return end;
    }
}