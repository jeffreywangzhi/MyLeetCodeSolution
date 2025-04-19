class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if ( s1.length() > s2.length() ) return false;
        int[] a1 = new int[26];
        int[] a2 = new int[26];
        for ( int i = 0; i < s1.length(); i++ ) {
            a1[s1.charAt(i)-'a']++;
            a2[s2.charAt(i)-'a']++;
        }
        int matches = 0;
        for ( int i = 0; i < 26; i++ ) {
            if ( a1[i] == a2[i] ) matches++;
        }
        if ( matches == 26 ) return true;
        int i = 1, j = i+s1.length()-1;
        while ( j < s2.length() ) {
            int k1 = s2.charAt(i-1)-'a';
            if ( --a2[k1] == a1[k1] ) matches++;
            else if ( a2[k1]+1 == a1[k1] ) matches--;
            int k2 = s2.charAt(j)-'a';
            if ( ++a2[k2] == a1[k2] ) matches++;
            else if ( a2[k2]-1 == a1[k2] ) matches--;
            if ( matches == 26 ) return true;
            i++;j++;
        }
        return false;
    }
}