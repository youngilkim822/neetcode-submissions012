class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        if(nums == null || nums.length == 0 || nums.length < k) return new int[]{};
        
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for(Integer num : nums){
            hashMap.put(num, hashMap.getOrDefault(num,0)+1);
        }

        List<Map.Entry<Integer, Integer>> list = new ArrayList<>();
        int temp = k;
        for(Map.Entry<Integer, Integer> entrySet : hashMap.entrySet()){
            list.add(entrySet);
        }

        list.sort((a,b)->b.getValue()-a.getValue());
        int[] arr = new int[k];
        for(int i=0; i<k; i++){
            arr[i] = list.get(i).getKey();
        }
        return arr;
    }
}
