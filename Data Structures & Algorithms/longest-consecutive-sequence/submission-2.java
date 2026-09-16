class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums == null || nums.length == 0) return 0;

        Set<Integer> set = new HashSet<>();
        for(Integer num : nums){
            set.add(num);
        }

        int ans = 0;
        for(Integer num : set){
            if(!set.contains(num-1)){
                int count = 1;
                int temp = num;
                while(set.contains(temp+1)){
                    count++;
                    temp++;
                }
                ans = Math.max(ans, count);
            }
        }
        return ans;
    }
}
