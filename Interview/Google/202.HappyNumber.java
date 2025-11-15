class Solution {
    public boolean isHappy(int n) {
        HashSet<Integer> set = new HashSet<>();
        while ( true ) {
            int tmp = n;
            int next = 0;
            while ( tmp > 0 ) {
                int cur = tmp%10;
                next += Math.pow(cur,2);
                tmp /= 10;
            }
            if ( next == 1 ) return true;
            if ( set.contains(next) ) return false;
            set.add(next);
            n = next;
        }
    }
}