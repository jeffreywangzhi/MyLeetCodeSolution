class Solution {
    public int reverse(int x) {
        boolean flag = x >= 0;
        x = Math.abs(x);
        int res = 0;
        while ( x > 0 ) {
            if ( res > Integer.MAX_VALUE/10 ) return 0;
            if ( (res == Integer.MAX_VALUE/10 && x%10 > 7 && flag) || (res == Integer.MAX_VALUE/10 && x%10 > 8 && !flag) ) return 0;
            res = res*10 + x%10;
            x /= 10;
        }
        return flag ? res : -res;
    }
}