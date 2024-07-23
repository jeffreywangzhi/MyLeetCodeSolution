class Solution {
    public String longestPalindrome(String s) {
        String res = "";
        for ( int i = 0; i < s.length(); i++ ) {
            res = helper(s,i,true,res);
            res = helper(s,i,false,res);
        }
        return res;
    }
    private String helper(String s, int p, boolean boo, String res) {
        int i = boo ? p-1 : p;
        int j = p+1;
        StringBuilder cur = boo ? new StringBuilder().append(s.charAt(p)) : new StringBuilder();
        for ( ; i >= 0 && j < s.length(); i--, j++ ) {
            if ( s.charAt(i) == s.charAt(j) ) {
                cur.insert(0,s.charAt(i));
                cur.append(s.charAt(j));
            } else break;
        }
        return res.length() > cur.length() ? res : cur.toString();
    }
}