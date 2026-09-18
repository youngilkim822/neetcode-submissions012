class Solution {
    public int[] twoSum(int[] num, int target) {
        if(num == null || num.length == 0) return new int[]{};

        int i=0;
        int j=num.length-1;
        while(i<j){
            int sum = num[i] + num[j];
            if(sum == target){
                return new int[]{i+1,j+1};
            }

            if(sum > target){
                j--;
            }else{
                i++;
            }
        }
        return new int[]{};
    }
}
