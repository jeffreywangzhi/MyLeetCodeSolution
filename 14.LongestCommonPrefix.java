class Solution {
    public String longestCommonPrefix(String[] strs) {
        if ( strs.length == 0 ) return "";
        if ( strs.length == 1 ) return strs[0];
        Arrays.sort(strs);
        String str1 = strs[0];
        String str2 = strs[strs.length - 1];
        StringBuilder ans = new StringBuilder();
        for ( int i = 0 ; i < Math.min( str1.length(), str2.length() ) ; i ++ ) {
            if ( str1.charAt(i) != str2.charAt(i) ) return ans.toString();
            else ans.append(str1.charAt(i));
        }
        return ans.toString();
    }
}