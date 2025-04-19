class Solution {
    public int lengthOfLongestSubstring(String s) {
        int i = 0, j = 0, res = 0;
        HashMap<Character,Integer> map = new HashMap<>();
        while ( j < s.length() ) {
            char cur = s.charAt(j);
            if ( !map.containsKey(cur) ) {
                map.put(cur,j);
                j++;
            } else {
                res = Math.max(res,j-i);
                while ( i < map.get(cur) ) {
                    map.remove(s.charAt(i));
                    i++;
                }
                i++;
                map.put(cur,j++);
            }
        }
        res = Math.max(res,j-i);
        return res;
    }
}