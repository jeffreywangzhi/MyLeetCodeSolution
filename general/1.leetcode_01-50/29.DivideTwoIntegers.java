class Solution {
    public int divide(int dividend, int divisor) {
        if ( dividend == Integer.MIN_VALUE && divisor == -1 ) return Integer.MAX_VALUE;
        if ( divisor == 1 ) return dividend;
        boolean sign = false;
        if ( dividend < 0 ^ divisor < 0 ) sign = true;
        long d = Math.abs(dividend), t = Math.abs(divisor), p = 1;
        if (dividend == Integer.MIN_VALUE ) {
            d = Integer.MAX_VALUE;
            d += 1;
        }
        if (divisor == Integer.MIN_VALUE ) {
            t = Integer.MAX_VALUE;
            t += 1;
        }
        int res = 0;
        while ( d >= t ) {
            if ( t << 1 < d ) {
                t = t << 1;
                p = p << 1;
            } else {
                res += p;
                d -= t;
                t = Math.abs(divisor);
                p = 1;
            }
        }
        return sign ? -res : res;
    }
}