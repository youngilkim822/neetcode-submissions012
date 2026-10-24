class Solution {
    public int climbStairs(int n) {
        if(n<=2) return n;

        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;

        if(n<=2) return dp[n];

        for(int i=3; i<n+1; i++){
            dp[i] = dp[i-1] + dp[i-2];
        }

        return dp[n];
    }
}
/*

n=10
dp[0] = 0
dp[1] = 1
dp[2] = 2

dp[3] = dp[1] + dp[2]







*/
