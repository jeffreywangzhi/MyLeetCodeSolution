class Solution {
    public String longestPalindrome(String s) {
        String res = "";
        for ( int i = 0; i < s.length(); i++ ) {
            String a = getPalind(i,i,s);
            String b = getPalind(i,i+1,s);
            String cur = a.length() > b.length() ? a : b;
            res = res.length() > cur.length() ? res : cur;
        }
        return res;
    }
    private String getPalind(int left, int right, String s) {
        while ( left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right) ) {
            left--;right++;
        }
        return s.substring(left+1,right);
    }
}