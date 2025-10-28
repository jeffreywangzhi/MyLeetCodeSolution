class Solution {
    public String longestPalindrome(String s) {
        int[] res = new int[2];
        for ( int i = 0; i < s.length(); i++ ) {
            int[] c1 = check(i,i,s);
            int l1 = c1[1]-c1[0]+1;
            int[] c2 = check(i,i+1,s);
            int l2 = c2[1]-c2[0]+1;
            if ( l1 >= l2 ) res = res[1]-res[0]+1 >= l1 ? res : c1;
            else res = res[1]-res[0]+1 >= l2 ? res : c2;
        }
        return s.substring(res[0],res[1]+1);
    }
    public int[] check(int i, int j, String s) {
        if ( j >= s.length() ) return new int[2];
        while ( i >= 0 && j < s.length() ) {
            char c1 = s.charAt(i);
            char c2 = s.charAt(j);
            if ( c1 != c2 ) break;
            i--;j++;
        }
        return new int[]{i+1,j-1};
    }
}