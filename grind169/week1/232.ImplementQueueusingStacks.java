class MyQueue {
    public Stack<Integer> stack = new Stack<Integer>();
    public Stack<Integer> temp = new Stack<Integer>();

    public MyQueue() {
        
    }
    
    public void push(int x) {
        int cnt = 0;
        while ( !stack.empty() ) {
            temp.push(stack.pop());
            cnt++;
        }
        stack.push(x);
        for ( int i = 0; i < cnt; i++ ) {
            stack.push(temp.pop());
        }
    }
    
    public int pop() {
        return stack.pop();
    }
    
    public int peek() {
        return stack.peek();
    }
    
    public boolean empty() {
        return stack.empty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */