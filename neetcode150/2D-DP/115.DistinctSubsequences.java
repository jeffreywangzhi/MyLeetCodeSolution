class Solution {
    public int numDistinct(String s, String t) {
        HashMap<String,Integer> map = new HashMap<>();
        return dfs(s,t,0,0,map);
    }
    public int dfs(String s, String t, int i, int j, HashMap<String,Integer> map) {
        if ( j == t.length() ) return 1;
        if ( i == s.length() ) return 0;
        String key = i+","+j;
        if ( map.containsKey(key) ) return map.get(key);
        if ( s.charAt(i) == t.charAt(j) ) map.put(key,dfs(s,t,i+1,j+1,map) + dfs(s,t,i+1,j,map));
        else map.put(key,dfs(s,t,i+1,j,map));
        return map.get(key);
    }
}