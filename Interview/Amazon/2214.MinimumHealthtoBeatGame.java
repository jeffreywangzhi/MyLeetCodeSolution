class Solution {
    public long minimumHealth(int[] damage, int armor) {
        long max = 0, total = 0;
        for ( int i = 0; i < damage.length; i++ ) {
            max = Math.max(max,damage[i]);
            total += damage[i];
        }
        if ( armor <= max ) {
            return total-armor+1;
        } else {
            return total-max+1;
        }
    }
}