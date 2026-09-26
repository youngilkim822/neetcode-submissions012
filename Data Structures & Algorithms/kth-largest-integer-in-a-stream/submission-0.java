class KthLargest {
    private PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> a-b);
    private int maxSize = 0;
    public KthLargest(int k, int[] nums) {
        maxSize = k;
        for(Integer num : nums){
            pq.add(num);
            if(pq.size() > k){
                pq.poll();
            }
        }
    }
    
    public int add(int val) {
        pq.add(val);
        if(pq.size() > maxSize){
            pq.poll();
        }
        return pq.peek();
    }
}
