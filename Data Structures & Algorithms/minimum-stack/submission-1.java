class MinStack {
    private Deque<int[]> deque;

    public MinStack() {
        this.deque = new ArrayDeque<>();    
    }
    
    public void push(int val) {
        int min = deque.isEmpty() ? val : Math.min(val, deque.peek()[1]);
        deque.push(new int[]{val, min});
    }
    
    public void pop() {
        if(!deque.isEmpty()) deque.pop();
    }
    
    public int top() {
        return !deque.isEmpty() ? deque.peek()[0] : -1;
    }
    
    public int getMin() {
        return !deque.isEmpty() ? deque.peek()[1] : -1;
    }
}
