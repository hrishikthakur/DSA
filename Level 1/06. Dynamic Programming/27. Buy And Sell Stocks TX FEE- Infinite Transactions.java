public static int maxProfit(int[] cost, int fee){

    int n = cost.length;
    int[][] dp = new int[n][2];
    // profit(wallet balance) at day 0 when ends with B
    dp[0][0] = -cost[0];
    // profit(wallet balance) at day 0 when ends with S
    dp[0][1] = 0;

    for(int day = 1; day < n; day++)
    {
        // Extra Buy
        dp[day][0] = Math.max(dp[day - 1][0], dp[day - 1][1] - cost[day]);
        // Complete Sell
        dp[day][1] = Math.max(dp[day - 1][1], dp[day - 1][0] + cost[day] - fee);
    }

    return dp[n - 1][1];
}
