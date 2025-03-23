class Solution {
    public long repairCars(int[] ranks, int cars) {
        long left = 1, right = (long) 1e14;
        while ( left < right ) {
            long mid = left+(right-left)/2;
            if ( helper(ranks,cars,mid) ) right = mid;
            else left = mid+1;
        }
        return right;
    }
    private boolean helper(int[] ranks, int cars, long mid) {
        int cnt = 0;
        for ( int r : ranks ) {
            cnt += Math.sqrt(mid/r);
            if ( cnt >= cars ) return true;
        }
        return cnt >= cars;
    }
}