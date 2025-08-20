class Solution {
    public int maxProfit(int[] prices) {
        HashMap<String,Integer> dp = new HashMap<>();
        return dfs(prices,dp,0,true);
    }
    public int dfs(int[] prices, HashMap<String,Integer> dp, int idx, boolean buying) {
        if ( idx >= prices.length ) return 0;
        StringBuilder curB = new StringBuilder();
        curB.append(idx).append(buying);
        String cur = curB.toString();
        if ( dp.containsKey(cur) ) return dp.get(cur);
        if ( buying ) {
            int buy = dfs(prices,dp,idx+1,false)-prices[idx];
            int cool = dfs(prices,dp,idx+1,buying);
            dp.put(cur,Math.max(buy,cool));
        } else {
            int sell = dfs(prices,dp,idx+2,true)+prices[idx];
            int cool = dfs(prices,dp,idx+1,buying);
            dp.put(cur,Math.max(sell,cool));
        }
        return dp.get(cur);
    }
}