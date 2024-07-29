class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int sum = 0, cur = 0, res = 0;
        for ( int i = 0; i < gas.length; i++ ) {
            cur = cur + gas[i] - cost[i];
            sum = sum + gas[i] - cost[i];
            if ( cur < 0 ) {
                res = i+1;
                cur = 0;
            }
        }
        return sum >= 0 ? res : -1;
    }
}