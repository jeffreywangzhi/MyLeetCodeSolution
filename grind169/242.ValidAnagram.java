class Solution {
    public boolean isAnagram(String s, String t) {
        if ( s.length() != t.length() ) return false;
        char[] arrS = s.toCharArray();
        char[] arrT = t.toCharArray();
        Arrays.sort(arrS);
        Arrays.sort(arrT);
        for ( int i = 0; i < arrS.length; i++ ) {
            if ( arrS[i] != arrT[i] ) return false;
        }
        return true;
    }
}