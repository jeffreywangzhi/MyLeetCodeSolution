class Solution {
    public String longestCommonPrefix(String[] strs) {
        if ( strs.length == 1 ) return strs[0];
        Arrays.sort(strs);
        for ( int i = strs[0].length(); i > 0; i-- ) {
            String pre = strs[0].substring(0,i);
            for ( int j = 1; j < strs.length; j++ ) {
                if ( !strs[j].startsWith(pre) ) break;
                if ( j == strs.length-1 ) return pre;
            }
        }
        return "";
    }
}