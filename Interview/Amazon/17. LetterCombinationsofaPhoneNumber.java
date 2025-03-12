class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if ( digits.length() <= 0 ) return res;
        HashMap<Character,List<Character>> map = new HashMap<>();
        map.put('2',new ArrayList<>(Arrays.asList('a','b','c')));
        map.put('3',new ArrayList<>(Arrays.asList('d','e','f')));
        map.put('4',new ArrayList<>(Arrays.asList('g','h','i')));
        map.put('5',new ArrayList<>(Arrays.asList('j','k','l')));
        map.put('6',new ArrayList<>(Arrays.asList('m','n','o')));
        map.put('7',new ArrayList<>(Arrays.asList('p','q','r','s')));
        map.put('8',new ArrayList<>(Arrays.asList('t','u','v')));
        map.put('9',new ArrayList<>(Arrays.asList('w','x','y','z')));
        dfs(digits,0,new StringBuilder(),map,res);
        return res;
    }
    private void dfs(String digits, int idx, StringBuilder cur, HashMap<Character,List<Character>> map, List<String> res) {
        if ( idx >= digits.length() ) {res.add(cur.toString());return;}
        for ( int i = 0; i < map.get(digits.charAt(idx)).size(); i++ ) {
            cur.append(map.get(digits.charAt(idx)).get(i));
            dfs(digits,idx+1,cur,map,res);
            cur.deleteCharAt(cur.length()-1);
        }
    }
}