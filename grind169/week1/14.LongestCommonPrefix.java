class Solution {
    public String longestCommonPrefix(String[] strs) {
        Arrays.sort(strs);
        String com = strs[0];
        for ( int i = 1; i < strs.length; i++ ) {
            if ( strs[i].indexOf(com) == 0 ) continue;
            else {
                int j = com.length()-1;
                for ( ; j > 0; i-- ) {
                    com = com.substring(0, j);
                    if ( strs[i].indexOf(com) == 0 ) break;
                }
                if ( j == 0 ) return "";
            }
        }
        return com;
    }
}