class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        HashMap<Character, Character> map = new HashMap<Character, Character>();
        map.put('(', ')');
        map.put('{', '}');
        map.put('[', ']');

        for ( char letter : s.toCharArray() ) {
            if ( map.containsKey(letter) ) {
                stack.push(letter);
            } else {
                if ( !stack.isEmpty() && map.get(stack.peek()) == letter ) {
                    stack.pop();
                } else return false;
            }
        }
        return stack.isEmpty();
    }
}