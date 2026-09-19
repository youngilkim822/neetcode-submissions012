class Solution {
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length == 0) return 0;

        int i=0;
        int ans = 0;
        for(int j=1; j<prices.length; j++){
            if(prices[i] >= prices[j]){
                i=j;
            }else if(prices[i] < prices[j]){
                ans = Math.max(ans, prices[j] - prices[i]);
            }
        }
        return ans;
    }
}
/*



  10


                    7
                6
            5



        1               1
*/