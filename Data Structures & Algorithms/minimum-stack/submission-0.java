class MinStack {
    private List<Integer> list;
    private PriorityQueue<Integer> pq;

    public MinStack() {
        this.list = new ArrayList<>();    
        this.pq = new PriorityQueue<>();
    }
    
    public void push(int val) {
        list.add(val);
        pq.add(val);

    }
    
    public void pop() {
        if(list.size() == 0) return;
        int last = list.remove(list.size()-1);
        pq.remove(last);
    }
    
    public int top() {
        if(list.size() == 0) return -1;
        return list.get(list.size()-1);
    }
    
    public int getMin() {
        return pq.isEmpty() ? -1 : pq.peek();
    }
}
