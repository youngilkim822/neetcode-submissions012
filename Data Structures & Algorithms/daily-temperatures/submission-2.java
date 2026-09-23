class Solution {
    public int[] dailyTemperatures(int[] temp) {
        if(temp == null) return new int[]{};
        if(temp.length == 1) return new int[]{};

        
        int[] res = new int[temp.length];
        res[res.length-1] = 0;

        int i=0;
        int j=1;
        while(i<temp.length && j<temp.length && i<j){
            if(temp[i] < temp[j]){
                res[i] = j-i;
                i++;
                j=i+1;
            }else{
                j++;
            }

            if(i<temp.length && j==temp.length){
                i++;
                j=i+1;
            }
        }
        
        return res;

    }
}
