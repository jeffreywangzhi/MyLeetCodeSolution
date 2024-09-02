class Solution {
    public int characterReplacement(String s, int k) {
        int[] dict = new int[26];
        int start = 0, end = 0, max = 0, res = 0;
        for ( ; end < s.length(); end++ ) {
            max = Math.max(max, ++dict[s.charAt(end)-'A']);
            if ( end - start - max + 1 > k ) {
                dict[s.charAt(start)-'A']--;
                start++;
            }
            res = Math.max(res,end-start+1);
        }
        return res;
    }
}