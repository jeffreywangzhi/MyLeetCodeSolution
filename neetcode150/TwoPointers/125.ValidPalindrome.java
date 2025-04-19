class Solution {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        int i = 0, j = s.length()-1;
        while ( i < j ) {
            char ci = s.charAt(i);
            if ( !Character.isLetter(ci) && !Character.isDigit(ci) ) {i++;continue;}
            char cj = s.charAt(j);
            if ( !Character.isLetter(cj) && !Character.isDigit(cj) ) {j--;continue;}
            if ( ci != cj ) return false;
            i++;j--;
        }
        return true;
    }
}