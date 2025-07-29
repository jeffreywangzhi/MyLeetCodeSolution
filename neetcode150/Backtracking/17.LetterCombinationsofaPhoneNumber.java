class Solution {
    public List<String> letterCombinations(String digits) {
        if ( digits.length() == 0 ) return new ArrayList<>();
        List<List<Character>> list = new ArrayList<>();
        list.add(new ArrayList<>(Arrays.asList('a','b','c')));
        list.add(new ArrayList<>(Arrays.asList('d','e','f')));
        list.add(new ArrayList<>(Arrays.asList('g','h','i')));
        list.add(new ArrayList<>(Arrays.asList('j','k','l')));
        list.add(new ArrayList<>(Arrays.asList('m','n','o')));
        list.add(new ArrayList<>(Arrays.asList('p','q','r','s')));
        list.add(new ArrayList<>(Arrays.asList('t','u','v')));
        list.add(new ArrayList<>(Arrays.asList('w','x','y','z')));
        List<String> res = new ArrayList<>();
        dfs(digits,0,list,res,"");
        return res;
    }
    private void dfs(String digits, int idx, List<List<Character>> list, List<String> res, String cur) {
        if ( cur.length() == digits.length() ) {res.add(cur);return;}
        for ( int i = 0; i < list.get(digits.charAt(idx)-'2').size(); i++ ) {
            cur += list.get(digits.charAt(idx)-'2').get(i);
            dfs(digits,idx+1,list,res,cur);
            cur = cur.substring(0,cur.length()-1);
        }
    }
}