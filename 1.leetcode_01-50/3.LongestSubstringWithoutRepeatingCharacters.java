class Solution {
    public int lengthOfLongestSubstring(String s) {
        int pre = 0;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        for(int i = 0 ; i < s.length() ; i ++){
            if(!map.containsKey(s.charAt(i))){
                map.put(s.charAt(i), i);
            }else{
                pre = Math.max(pre, map.size());
                i = map.get(s.charAt(i));
                map.clear();
                
            }
        }
        return Math.max(pre, map.size());
    }
}