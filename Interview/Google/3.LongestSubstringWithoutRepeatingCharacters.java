class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character,Integer> map = new HashMap<>();
        int i = 0, j = 0;
        int res = 0;
        while ( j < s.length() ) {
            char c = s.charAt(j);
            if ( !map.containsKey(c) ) map.put(c,j);
            else {
                res = Math.max(res,j-i);
                i = Math.max(i,map.get(c)+1);
                map.put(c,j);
            }
            j++;
        }
        res = Math.max(res,j-i);
        return res;
    }
}