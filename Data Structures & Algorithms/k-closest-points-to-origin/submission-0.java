class Solution {
    public int[][] kClosest(int[][] points, int k) {
        if(points == null || k == 0) return new int[][]{};

        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a,b) -> (b[0]*b[0] + b[1]*b[1])-(a[0]*a[0] + a[1]*a[1])
        );

        for(int[] point : points){
            pq.add(point);
            if(pq.size() > k){
                pq.poll();
            }
        }

        List<int[]> list = new ArrayList<>();
        while(!pq.isEmpty()){
            list.add(pq.poll());
        }
        return list.toArray(new int[0][]);
    }
}


















