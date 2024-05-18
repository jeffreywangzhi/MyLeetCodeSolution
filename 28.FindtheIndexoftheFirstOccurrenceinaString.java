class Solution {
    public int strStr(String haystack, String needle) {
        int haylen = haystack.length();
        int neelen = needle.length();
        if ( neelen > haylen ) return -1;
        for ( int i = 0; i < haylen; i++ ) {
            int j = 0;
            while ( j < neelen && j+i < haylen && haystack.charAt(j+i) == needle.charAt(j) ) {
                if ( j == neelen - 1 ) return i;
                j++;
            }
        }
        return -1;
    }
}