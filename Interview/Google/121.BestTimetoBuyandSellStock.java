class Solution {
    public int maxProfit(int[] prices) {
        int min = prices[0], res = 0;
        for ( int p : prices ) {
            min = Math.min(min,p);
            res = Math.max(res,p-min);
        }
        return res;
    }
}