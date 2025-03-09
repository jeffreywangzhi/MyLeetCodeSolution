class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        HashMap<Character,Character> map = new HashMap<>();
        map.put('(',')');
        map.put('[',']');
        map.put('{','}');
        for ( char c : s.toCharArray() ) {
            if ( map.containsKey(c) ) stack.push(c);
            else {
                if ( stack.isEmpty() ) return false;
                if ( c != map.get(stack.peek()) ) return false;
                stack.pop();
            }
        }
        return stack.isEmpty();
    }
}