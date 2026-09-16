class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums == null || nums.length == 0) return 0;

        Arrays.sort(nums);
        int count = 1;
        int ans = 0;
        for(int i=0; i<nums.length; i++){
            if(i+1 < nums.length && nums[i+1] == nums[i]+1){
                count++;
            }else if(i+1 < nums.length && nums[i+1] == nums[i]){
                continue;
            }else{
                ans = Math.max(ans, count);
                count = 1;
            }
        }
        return ans;
    }
}
