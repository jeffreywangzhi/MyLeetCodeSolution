class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        HashMap<String,Integer> map = new HashMap<>();
        for ( int i = 0; i < strs.length; i++ ) {
            char[] temp = strs[i].toCharArray();
            Arrays.sort(temp);
            String str = new String(temp);
            if ( !map.containsKey(str) ) {
                map.put(str,res.size());
                res.add(new ArrayList<>(Arrays.asList(strs[i])));
            } else {
                res.get(map.get(str)).add(strs[i]);
            }
        }
        return res;
    }
}