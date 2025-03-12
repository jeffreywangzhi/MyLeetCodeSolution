class Solution {
    public int compress(char[] chars) {
        int res = 0, cnt = 1;
        for ( int i = 1; i <= chars.length; i++ ) {
            if ( i < chars.length && chars[i] == chars[i-1] ) cnt++;
            else {
                chars[res++] = chars[i-1];
                if ( cnt > 1 ) {
                    for ( char c : Integer.toString(cnt).toCharArray() ) chars[res++] = c;
                }
                cnt = 1;
            }
        }
        return res;
    }
}