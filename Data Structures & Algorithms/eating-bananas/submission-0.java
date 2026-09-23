class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        if(piles == null || piles.length > h) return 0;

        int min = 1;
        int max = 0;
        for(Integer pile : piles){
            max = Math.max(max, pile);
        }

        int ans = max;
        while(min <= max){
            int mid = min + (max - min)/2;
            int temp = calculate(piles, mid);

            if(temp > h){
                min = mid+1;
            }else{
                ans = mid;
                max = mid-1;
            }
        }
        return ans;
    }

    private int calculate(int[] piles, int k){
        int sum = 0;
        for(int i=0; i<piles.length; i++){
            int hour = piles[i]/k;
            if(hour == 0){
                sum += 1;
            }else{
                sum += hour;
                if(piles[i] % k != 0){
                    sum += 1;
                }
            }
        }
        return sum;
    }
}
