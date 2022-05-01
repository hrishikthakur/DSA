// Approach 1 -> With cooldown Column
public static int maxProfit(int[] cost){

    int n = cost.length;
    int[][] dp = new int[n][3];

    dp[0][0] = -cost[0];
    dp[0][1] = 0;
    dp[0][2] = 0;

    for(int i = 1; i < n; i++){
        // extra buy
        dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][2] - cost[i]);

        // Complete sell
        dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] + cost[i]);

        // Complete sell with Cooldown
        dp[i][2] = Math.max(dp[i - 1][2], dp[i - 1][1]);
    }

    return dp[n - 1][1];
}


// Approach 2 -> Without cooldown Column
public static int maxProfit(int[] cost){

    int n = cost.length;
    int[][] dp = new int[n][2];

    dp[0][0] = -cost[0];
    dp[0][1] = 0;

    for(int i = 1; i < n; i++){
        //Extra Buy
        dp[i][0] = Math.max(dp[i - 1][0], (i - 2) > 0 ? dp[i - 2][1] - cost[i] : -cost[i]);

        // Complete Sell
        dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] + cost[i]);
    }

    return dp[n - 1][1];
}
