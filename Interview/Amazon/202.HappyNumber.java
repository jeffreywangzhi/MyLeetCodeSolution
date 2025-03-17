class Solution {
    public boolean isHappy(int n) {
        HashSet<Integer> set = new HashSet<>();
        while ( true ) {
            int num = 0;
            while ( n > 0 ) {
                num += Math.pow(n%10,2);
                n = n/10;
            }
            if ( num == 1 ) return true;
            if ( set.contains(num) ) return false;
            else {
                set.add(num);
                n = num;
            }
        }
    }
}