class Solution {
    public int[] closestPrimes(int left, int right) {
        List<Integer> list = new ArrayList<>();
        for ( int i = left; i <= right; i++ ) {
            if ( isPrime(i) ) list.add(i);
        }
        int[] res = new int[]{-1,-1};
        int gap = Integer.MAX_VALUE;
        for ( int i = 1; i < list.size(); i++ ) {
            int a = list.get(i-1);
            int b = list.get(i);
            if ( b-a < gap ) {
                gap = b-a;
                res[0] = a;
                res[1] = b;
            }
        }
        return res;
    }
    private boolean isPrime(int n) {
        if ( n < 2 ) return false;
        if ( n == 2 || n == 3 ) return true;
        if ( n%2 == 0 || n%3 == 0 ) return false;
        for ( int i = 5; i*i <= n; i+=6 ) {
            if ( n%i == 0 || n%(i+2) == 0 ) return false;
        }
        return true;
    }
}