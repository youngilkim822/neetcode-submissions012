class Solution {
    public int[] productExceptSelf(int[] nums) {
        if(nums == null || nums.length == 0) return new int[]{};

        int n = nums.length;
        int[] arr1 = new int[n];
        int[] arr2 = new int[n];
        int[] arr3 = new int[n];

        arr1[0] = 1;
        for(int i=1; i<n; i++){
            arr1[i] = arr1[i-1] * nums[i-1];
        }

        arr2[n-1] = 1;
        for(int i=n-2; i>=0; i--){
            arr2[i] = arr2[i+1] * nums[i+1];
        }

        for(int i=0; i<n; i++){
            arr3[i] = arr1[i] * arr2[i];
        }

        return arr3;
    }
}  
/*
nums = [1,2,0,3,4]
arr1 = [1,1,2,0,0]
arr2 = [0,0,12,4,1]
arr3 = [0,0,24,0,0]

*/