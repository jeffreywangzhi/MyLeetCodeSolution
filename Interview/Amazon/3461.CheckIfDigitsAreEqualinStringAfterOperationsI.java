class Solution {
    public boolean hasSameDigits(String s) {
        while ( s.length() > 2 ) {
            StringBuilder cur = new StringBuilder();
            for ( int i = 0; i < s.length()-1; i++ ) cur.append(((s.charAt(i)-'0')+(s.charAt(i+1)-'0'))%10);
            s = cur.toString();
        }
        return s.charAt(0) == s.charAt(1) ? true : false;
    }
}