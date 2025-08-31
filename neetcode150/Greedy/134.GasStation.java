class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int total = 0, sum = 0, res = 0;
        for ( int i = 0; i < gas.length; i++ ) {
            int cur = gas[i]-cost[i];
            total += cur;
            sum += cur;
            if ( total < 0 ) {
                total = 0;
                res = i+1;
            }
        }
        return sum >= 0 ? res : -1;
    }
}