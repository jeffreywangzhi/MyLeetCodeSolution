class Solution {
    public int strStr(String haystack, String needle) {
        return helper(haystack,needle,haystack.length());
    }
    private int helper(String haystack, String needle, int len) {
        if ( needle.length() > haystack.length() ) return -1;
        if ( haystack.startsWith(needle) ) return len-haystack.length();
        else return helper(haystack.substring(1),needle,len);
    }
}