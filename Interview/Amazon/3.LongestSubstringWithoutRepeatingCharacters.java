class Solution {
    public int lengthOfLongestSubstring(String s) {
        int start = 0, res = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        for (int end = 0; end < s.length(); end++) {
            char cur = s.charAt(end);
            if (map.containsKey(cur)) {
                res = Math.max(res, end - start);
                start = Math.max(start, map.get(cur) + 1);
            }
            map.put(cur, end);
        }
        return Math.max(res, s.length() - start);
    }
}
