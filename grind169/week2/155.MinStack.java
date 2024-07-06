class MinStack {
    private Stack<Integer> st1;
    private int min;

    public MinStack() {
        st1 = new Stack<>();
        min = Integer.MAX_VALUE;
    }
    
    public void push(int val) {
        if ( val <= min ) {
            st1.push(min);
            min = val;
        }
        st1.push(val);
    }
    
    public void pop() {
        if ( st1.pop().equals(min) ) min = st1.pop();
    }
    
    public int top() {
        return st1.peek();
    }
    
    public int getMin() {
        return min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */