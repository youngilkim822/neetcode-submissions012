class Solution {
    public int trap(int[] height) {
        if(height == null || height.length <= 2) return 0;

        int hightest = height[0];
        int hightestIndex = 0;
        for(int i=0; i<height.length; i++){
            if(hightest < height[i]){
                hightest = height[i];
                hightestIndex = i;
            }
        }

        int leftHightest = 0;
        int leftMax = 0;
        for(int i=0; i<hightestIndex; i++){
            leftHightest = Math.max(leftHightest, height[i]);
            leftMax += leftHightest - height[i]; 
        }

        int rightHightest = 0;
        int rightMax = 0;
        for(int i=height.length-1; i>hightestIndex; i--){
            rightHightest = Math.max(rightHightest, height[i]);
            rightMax += rightHightest - height[i]; 
        }

        return leftMax + rightMax;
    }
}
