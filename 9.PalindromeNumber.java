class Solution {
    public boolean isPalindrome(int x) {
        if ( x < 0 ) return false;
        String str = Integer.toString(x);  
        int mid = str.length()/2;
        if ( str.length() % 2 == 1){
            for ( int i = mid - 1, j = mid + 1; i >= 0 && j < str.length() ; i--, j++) {
                if (str.charAt(i) != str.charAt(j)) return false;
            }
        }else {
            for ( int i = mid - 1, j = mid; i >= 0 && j < str.length() ; i--, j++) {
                if (str.charAt(i) != str.charAt(j)) return false;
            }
        }
        return true;
    }
}