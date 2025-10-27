class Solution {
    public boolean isPalindrome(int x) {
        if ( x < 0 ) return false;
        int res = 0, cur = x;
        while ( cur > 0 ) {
            res = res*10+cur%10;
            cur /= 10;
        }
        return res == x;
    }
}