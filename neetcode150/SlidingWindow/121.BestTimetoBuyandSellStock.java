class Solution {
    public int maxProfit(int[] prices) {
        int res = 0, low = prices[0];
        for ( int p : prices ) {
            low = Math.min(low,p);
            res = Math.max(res,p-low);
        }
        return res;
    }
}