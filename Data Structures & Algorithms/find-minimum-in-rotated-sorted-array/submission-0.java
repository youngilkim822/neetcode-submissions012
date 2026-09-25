class Solution {
    public int findMin(int[] nums) {
        if(nums == null || nums.length == 0) return -1;

        int left = 0;
        int right = nums.length-1;
        while(left < right){
            if(nums[left] < nums[right]) break;

            int mid = left + (right - left)/2;

            if(nums[mid] > nums[right]){
                left = mid+1;
            }else{
                right = mid;
            }
        }
        return nums[left];
    }
}
/*

L   L M   R
3 4 5 6 1 2

nums[L] < num[M] , num[M] < num[R]
then L = M;


L   M     R 
4 5 0 1 2 3

num[L] > num[M] , num [M] < num[R]
then R = M
*/