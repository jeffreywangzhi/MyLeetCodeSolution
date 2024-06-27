class Solution {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        int i = 0, j = s.length()-1;
        while ( i < j ) {
            if ( !Character.isLetter(s.charAt(i)) && !Character.isDigit(s.charAt(i)) ) i++;
            else if ( !Character.isLetter(s.charAt(j)) && !Character.isDigit(s.charAt(j)) ) j--;
            else {
                if ( s.charAt(i) == s.charAt(j) ) {
                    i++;
                    j--;
                } else return false;
            }
        }
        return true;
    }
}