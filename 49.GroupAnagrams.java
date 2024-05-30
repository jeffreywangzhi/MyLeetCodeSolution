class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for ( String str : strs ) {
            char[] word = str.toCharArray();
            Arrays.sort(word);
            String sortedword = new String(word);
            if ( !(map.containsKey(sortedword)) ) map.put(sortedword, new ArrayList<>());
            map.get(sortedword).add(str);
        }
        return new ArrayList<>(map.values());

    }
}