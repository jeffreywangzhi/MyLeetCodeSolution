class Solution {
    public int characterReplacement(String s, int k) {
        int i = 0, j = 0, res = 0;
        char maxChar = ' '; int max = 0;
        HashMap<Character,Integer> map = new HashMap<>();
        while ( j < s.length() ) {
            char cur = s.charAt(j);
            map.put(cur,map.getOrDefault(cur,0)+1);
            if ( map.get(cur) > max ) {
                maxChar = cur;
                max = map.get(cur);
            }
            if ( (j-i+1) - max <= k ) {
                res = Math.max(res,j-i+1);
                j++;
            } else {
                map.put(s.charAt(i),map.get(s.charAt(i))-1);
                i++;
                j++;
            }
        }
        return res;
    }
}