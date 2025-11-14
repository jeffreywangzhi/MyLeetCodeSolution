class Solution {
    public boolean isValid(String s) {
        HashMap<Character,Character> map = new HashMap<>();
        map.put('(',')');
        map.put('[',']');
        map.put('{','}');
        Stack<Character> stack = new Stack<>();
        for ( Character c : s.toCharArray() ) {
            if ( map.containsKey(c) ) stack.push(c);
            else if ( !stack.isEmpty() && map.get(stack.pop()) == c ) continue;
            else return false;
        }
        return stack.isEmpty();
    }
}