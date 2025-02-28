class FreqStack {
    HashMap<Integer,Integer> freq;
    HashMap<Integer,Stack<Integer>> map;
    int max;
    public FreqStack() {
        freq = new HashMap<>();
        map = new HashMap<>();
        max = 0;
    }
    
    public void push(int val) {
        freq.put(val,freq.getOrDefault(val,0)+1);
        int f = freq.get(val);
        max = Math.max(max,f);
        if ( !map.containsKey(f) ) {
            map.put(f,new Stack<>());
        }
        map.get(f).push(val);
    }
    
    public int pop() {
        int p = map.get(max).pop();
        freq.put(p,max-1);
        if ( map.get(max).isEmpty() ) max--;
        return p;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */