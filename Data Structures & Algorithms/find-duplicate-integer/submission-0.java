class Solution {
    public int findDuplicate(int[] nums) {
        if(nums == null || nums.length == 0) return 0;

        Set<Integer> set = new HashSet<>();
        for(Integer num : nums){
            if(set.contains(num)) return num;
            set.add(num);
        }
        return -1;
    }
}
