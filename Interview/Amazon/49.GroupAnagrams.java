class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>> map = new HashMap<>();
        for ( String str : strs ) {
            char[] word = str.toCharArray();
            Arrays.sort(word);
            String s = new String(word);
            if ( map.containsKey(s) ) {
                map.get(s).add(str);
            } else {
                map.put(s,new ArrayList<>(Arrays.asList(str)));
            }
        }
        return new ArrayList<>(map.values());
    }
}