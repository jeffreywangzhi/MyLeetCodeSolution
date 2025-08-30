class Solution {
    public int minDistance(String word1, String word2) {
        HashMap<String,Integer> map = new HashMap<>();
        return dfs(word1,word2,map,0,0);
    }
    public int dfs(String word1, String word2, HashMap<String,Integer> map, int i, int j) {
        if ( i == word1.length() ) return word2.length()-j;
        if ( j == word2.length() ) return word1.length()-i;
        String key = i+","+j;
        if ( map.containsKey(key) ) return map.get(key);
        int ans;
        if ( word1.charAt(i) == word2.charAt(j) ) ans = dfs(word1,word2,map,i+1,j+1);
        else {
            int insert = dfs(word1,word2,map,i,j+1);
            int delete = dfs(word1,word2,map,i+1,j);
            int replace = dfs(word1,word2,map,i+1,j+1);
            ans = 1+Math.min(insert,Math.min(delete,replace));
        }
        map.put(key,ans);
        return map.get(key);
    }
}