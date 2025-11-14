class Solution {
    public int strStr(String haystack, String needle) {
        int idx = 0;
        while ( haystack.length() >= needle.length() ) {
            if ( haystack.startsWith(needle) ) return idx;
            haystack = haystack.substring(1);
            idx++;
        }
        return -1;
    }
}