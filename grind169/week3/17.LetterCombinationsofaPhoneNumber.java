class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        String[] map = new String[] {"abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        helper(digits,map,res,new StringBuilder(),0);
        return res;
    }
    private void helper(String digits, String[] map, List<String> res, StringBuilder cur, int level) {
        if ( level >= digits.length() ) return;
        for ( char ch : map[digits.charAt(level)-'2'].toCharArray() ) {
            cur.append(ch);
            if ( cur.length() == digits.length() ) {
                res.add(cur.toString());
            } else helper(digits,map,res,cur,level+1);
            cur.deleteCharAt(cur.length()-1);
        }
    }
}