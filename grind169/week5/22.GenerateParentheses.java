class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        helper(n,"",0,0,res);
        return res;
    }
    public void helper(int n, String s, int left, int right, List<String> res) {
        if ( s.length() == n*2 ) {res.add(s);return;}
        if ( left < n ) helper(n,s+"(",left+1,right,res);
        if ( left > right ) helper(n,s+")",left,right+1,res);
    }
}