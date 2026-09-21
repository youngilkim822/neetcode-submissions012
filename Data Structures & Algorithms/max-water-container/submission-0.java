class Solution {
    public int maxArea(int[] heights) {
        if(heights == null || heights.length < 2) return 0;

        int left = 0;
        int right = heights.length-1;
        int max = 0;
        while(left < right){
            int area = (right-left) * Math.min(heights[left], heights[right]);
            max = Math.max(max, area);

            if(heights[left] < heights[right]){
                left++;
            }else{
                right--;
            }
        }

        return max;
    }
}

/*
 l             r   
 0 1 2 3 4 5 6 7
[1 7 2 5 4 7 3 6]
*/
