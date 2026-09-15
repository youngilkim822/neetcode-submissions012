class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        if (nums == null || nums.length == 0 || nums.length < k)
            return new int[] {};

        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (Integer num : nums) {
            hashMap.put(num, hashMap.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> hashMap.get(a) - hashMap.get(b));
        for (Map.Entry<Integer, Integer> entrySet : hashMap.entrySet()) {
            Integer key = entrySet.getKey();
            Integer value = entrySet.getValue();                
            pq.add(key);
            if(pq.size() > k){
                pq.poll();
            }
        }

        int[] arr = new int[k];
        int i=0;
        while(!pq.isEmpty()){
            arr[i] = pq.poll();
            i++;
        }
        return arr;
    }
}
