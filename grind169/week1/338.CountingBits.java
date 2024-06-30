class Solution {
    public int[] countBits(int n) {
        int res[] = new int[n+1];
        res[0] = 0;
        for ( int i = 1; i < res.length; i++ ) {
            res[i] = res[i & (i-1)] + 1;
        }
        return res;
    }
}