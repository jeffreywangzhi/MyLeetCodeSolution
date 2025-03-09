class Solution {
    public int maxProfit(int[] prices) {
        int res = 0;
        int min = Integer.MAX_VALUE;
        for ( int num : prices ) {
            min = Math.min(min,num);
            res = Math.max(res,num-min);
        }
        return res;
    }
}