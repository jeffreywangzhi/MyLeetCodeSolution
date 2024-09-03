class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        for ( int ast : asteroids ) {
            if ( ast > 0 || stack.empty() || stack.peek() < 0 ) {
                stack.push(ast);
            } else {
                while ( !stack.empty() ) {
                    if ( stack.peek() > 0 ) {
                        if ( stack.peek() <= Math.abs(ast) ) {
                            if ( stack.pop() == Math.abs(ast) ) break;
                            else if ( stack.empty() ) {stack.push(ast);break;}
                        } else break;
                    } else {stack.push(ast);break;}
                }
            }
        }
        int[] res = new int[stack.size()];
        for ( int i = res.length-1; i >= 0; i-- ) res[i] = stack.pop();
        return res;
    }
}