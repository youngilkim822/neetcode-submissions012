class Solution {
    public int minCostClimbingStairs(int[] cost) {
        if(cost == null) return 0;
        
        int[] dp = new int[cost.length];
        dp[0] = cost[0];
        dp[1] = cost[1];

        for(int i=2; i<dp.length; i++){
            dp[i] = cost[i] + Math.min(dp[i-1], dp[i-2]);
        }

        return Math.min(dp[cost.length-1], dp[cost.length-2]);
    }
}
/*
 0 1 2 3 4 5 6
[1 2 1 2 1 1 1]
 1 2 2 4 3 4 4
*/