class Solution {
    public boolean hasDuplicate(int[] nums) {
        if(nums == null) return true;
        Set<Integer> set = new HashSet<>();

        for(Integer num : nums){
            if(set.contains(num)) return true;
            set.add(num);
        }
        return false;
    }
}