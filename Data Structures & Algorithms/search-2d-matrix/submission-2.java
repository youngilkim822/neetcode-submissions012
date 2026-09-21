class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null) return false;

        int i=0;
        int j=matrix.length-1;

        while(i<=j){
            int mid = i+(j-i)/2;
            if(matrix[mid][0] == target){
                return true;
            }else if(matrix[mid][0] < target){
                i = mid+1;
            }else{
                j = mid-1;
            }
        }
        if(j<0) return false;
        for(int k=0; k<matrix[0].length; k++){
            if(matrix[j][k] == target) return true;
        }
        return false;
    }
}
