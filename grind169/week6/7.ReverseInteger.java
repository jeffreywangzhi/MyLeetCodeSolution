class Solution {
    public int reverse(int x) {
        boolean flag = x > 0 ? true : false;
        x = Math.abs(x);
        int res = 0;
        while ( x > 0 ) {
            int res1 = res * 10 + x % 10;
            long res2 = ((long)res * 10) + x % 10;
            if ( res1 != res2 ) return 0;
            res = res1;
            x /= 10;
        }
        return flag ? res : 0-res;
    }
}