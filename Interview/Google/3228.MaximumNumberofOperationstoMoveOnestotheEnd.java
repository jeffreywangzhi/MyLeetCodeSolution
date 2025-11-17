class Solution {
    public int maxOperations(String s) {
        int cnt = 0, res = 0;
        for ( int i = s.length()-1; i >= 0; i-- ) {
            if ( s.charAt(i) == '0' ) {
                if ( i+1 == s.length() || (i+1 < s.length() && s.charAt(i+1) != '0') ) cnt++;
            } else if ( s.charAt(i) == '1' ) res += cnt;
        }
        return res;
    }
}