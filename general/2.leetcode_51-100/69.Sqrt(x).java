class Solution {
    public int mySqrt(int x) {
        if ( x <= 1 ) return x;
        long left = 0, right = x, cur = ( left + right ) / 2;
        while ( left < right ) {
            if ( ( cur * cur ) == x ) return (int) cur;
            if ( ( cur * cur ) > x ) right = cur;
            else left = cur + 1;
            cur = ( left + right ) / 2;
        }
        return (int) cur - 1;
    }
}