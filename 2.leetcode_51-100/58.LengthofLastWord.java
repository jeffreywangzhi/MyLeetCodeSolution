class Solution {
    public int lengthOfLastWord(String s) {
        int res = 0;
        boolean flag = false;
        for ( int i = s.length()-1; i >=0; i-- ) {
            if ( Character.isLetter(s.charAt(i)) ) {res++; flag=true;}
            if ( s.charAt(i) == ' ' && flag ) break;
        }
        return res;
    }
}