class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();

        for(int i=0; i<nums.length; i++){
            int numsj = target - nums[i];
            if(hashMap.containsKey(numsj)) return new int[]{hashMap.get(numsj),i};
            hashMap.put(nums[i], i);
        }

        return new int[]{};
    }
}
