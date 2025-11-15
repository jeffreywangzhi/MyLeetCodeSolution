class Solution {
    public int minNumberOperations(int[] target) {
        int curHeight = 0, res = 0;
        for ( int i = 0; i < target.length; i++ ) {
            if ( target[i] > curHeight ) res += target[i]-curHeight;
            curHeight = target[i];
        }
        return res;
    }
}