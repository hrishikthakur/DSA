// ************************************ Tabulation ************************************

public static int paintHouse(int[][] cost){

    int n = cost.length;
    int[][] dp = new int[n][3];
    dp[0][0] = cost[0][0]; // cost of painting 0th house color = red
    dp[0][1] = cost[0][1]; // cost of painting 0th house color = green
    dp[0][2] = cost[0][2]; // cost of painting 0th house color = blue

    for(int house = 1; house < n; house++)
    {
        // paint curr house RED
        // cost of painting current house red => pichla house green ya blue paint kiya hoga
        // min(cost of painting ALL PREVIOUS HOUSES, with last house painted [green || blue] )
        // + cost of painting current house red
        dp[house][0] = Math.min(dp[house - 1][1], dp[house - 1][2]) + cost[house][0];

        // paint curr house GREEN
        dp[house][1] = Math.min(dp[house - 1][0], dp[house - 1][2]) + cost[house][1];

        // paint curr house BLUE
        dp[house][2] = Math.min(dp[house - 1][0], dp[house - 1][1]) + cost[house][2];
    }

    return Math.min(dp[n - 1][0], Math.min(dp[n - 1][1], dp[n - 1][2]));
}

// int[][] cost = new int[n][3];

// for(int house = 0; house < n; house++)
// {
//   for(int color = 0; color < 3; color++)
//       cost[house][color] = scn.nextInt();
// }

// System.out.println(paintHouse(cost));
