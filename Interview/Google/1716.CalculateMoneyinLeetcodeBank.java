class Solution {
    public int totalMoney(int n) {
        int week = 1, res = 0;
        while ( week <= n/7+1 ) {
            for ( int i = 1; i <= 7 && 7*(week-1)+i <= n; i++ ) {
                res += week-1+i;
            }
            week++;
        }
        return res;
    }
}