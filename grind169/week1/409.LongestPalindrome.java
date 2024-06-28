class Solution {
    public int longestPalindrome(String s) {
        if ( s.length() == 1 ) return 1;
        char[] arr = s.toCharArray();
        Arrays.sort(arr);
        int res = 0;
        boolean flag = false;
        for ( int i = 0; i < arr.length; i++ ) {
            if ( i+1 < arr.length && arr[i] == arr[i+1] ) {
                res += 2;
                i++;
            } else if ( !flag ) {
                res++;
                flag = true;
            } 
        }
        return res;
    }
}