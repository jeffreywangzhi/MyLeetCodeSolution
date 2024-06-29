class Solution {
    public boolean backspaceCompare(String s, String t) {
        int i = s.length()-1, j = t.length()-1, cnt1 = 0, cnt2 = 0;
        while ( i >= 0 || j >= 0 ) {
            while ( i >= 0 && ( s.charAt(i) == '#' || cnt1 > 0 ) ) {
                if ( s.charAt(i--) == '#' ) cnt1++;
                else cnt1--;
            }
            while ( j >= 0 && ( t.charAt(j) == '#' || cnt2 > 0 ) ) {
                if ( t.charAt(j--) == '#' ) cnt2++;
                else cnt2--;
            }
            if ( (i < 0) || (j < 0) ) return i < 0 && j < 0;
            if ( s.charAt(i--) != t.charAt(j--) ) return false;
        }
        return true;
    }
}