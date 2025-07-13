class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int res = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        for ( int i = 0; i < position.length; i++ ) map.put(position[i],speed[i]);
        Arrays.sort(position);
        Stack<Double> stack = new Stack<>();
        for ( int i = position.length-1; i >= 0; i-- ) {
            int pos = position[i];
            int key = map.get(pos);
            double t = (target-pos)/(double)key;
            if ( stack.isEmpty() || t > stack.peek() ) stack.push(t);
        }
        return stack.size();
    }
}