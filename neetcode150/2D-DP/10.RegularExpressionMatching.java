class Solution {
    public boolean isMatch(String s, String p) {
        HashMap<String,Boolean> dp = new HashMap<>();
        return dfs(s,p,0,0,dp);
    }
    public boolean dfs(String s, String p, int i, int j, HashMap<String,Boolean> dp) {
        String key = i+","+j;
        if ( dp.containsKey(key) ) return dp.get(key);
        if ( i >= s.length() && j >= p.length() ) return true;
        if ( j >= p.length() ) return false;
        boolean match = i < s.length() && (( s.charAt(i) == p.charAt(j) ) || p.charAt(j) == '.');
        boolean res = false;
        if ( j+1 < p.length() && p.charAt(j+1) == '*' ) res = dfs(s,p,i,j+2,dp) || ( match && dfs(s,p,i+1,j,dp) );
        else if ( match ) res = dfs(s,p,i+1,j+1,dp);
        dp.put(key,res);
        return res;
    }
}