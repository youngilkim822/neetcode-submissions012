class Solution {
    public int lastStoneWeight(int[] stones) {
        if(stones == null || stones.length == 0) return 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b-a);
        for(Integer stone : stones){
            pq.add(stone);
        }

        int ans = 0;
        while(!pq.isEmpty()){
            if(pq.size() == 1){
                return pq.peek();
            }
            int x = pq.poll();
            int y = pq.poll();

            if(x > y){
                pq.add(x-y);
            }else if(x < y){
                pq.add(y-x);
            }
        }
        return 0;
    }
}
