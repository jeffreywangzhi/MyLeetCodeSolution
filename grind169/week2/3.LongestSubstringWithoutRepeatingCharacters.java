class Solution {
    public int lengthOfLongestSubstring(String s) {
        int max = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        for ( int i = 0; i < s.length(); i++ ) {
            if ( map.containsKey(s.charAt(i)) ) {
                max = Math.max(max,map.size());
                i = map.get(s.charAt(i));
                map.clear();
            } else {
                map.put(s.charAt(i), i);
            }
        }
        max = Math.max(max,map.size());
        return max;
    }
}