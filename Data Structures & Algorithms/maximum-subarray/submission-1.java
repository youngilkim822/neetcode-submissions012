class Solution {
    public int maxSubArray(int[] nums) {
        if(nums == null) return 0;
        if(nums.length == 1) return nums[0];

        int sum = nums[0];
        int max = nums[0];
        for(int i=1; i<nums.length; i++){
            sum = Math.max(nums[i], sum + nums[i]);
            max = Math.max(max, sum);
        }
        return max;
    }
}
