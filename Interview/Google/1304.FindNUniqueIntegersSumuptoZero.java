class Solution {
    public int[] sumZero(int n) {
        int[] res = new int[n];
        int idx = 0;
        for ( int i = 1; i <= n/2; i++ ) {
            res[idx++] = i;
            res[idx++] = -i;
        }
        if ( n%2 == 1 ) res[idx] = 0;
        return res;
    }
}