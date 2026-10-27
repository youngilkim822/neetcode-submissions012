class Solution {
    public int maxSubArray(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];

        int sum = 0;
        int max = nums[0];

        for(int i=0; i<nums.length; i++){
            sum = Math.max(nums[i], sum + nums[i]);
            max = Math.max(max, sum);
        }

        return max;
    }
}