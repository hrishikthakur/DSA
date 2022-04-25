// ************************************ Tabulation ************************************

// METHOD -> O(n^3)
public static int paintHouse(int[][] cost){

    int n = cost.length; int k = cost[0].length;

    // dp[house][color] ->
    int[][] dp = new int[n][k];
    // trivial problem
    for(int color = 0; color < k; color++)
        dp[0][color] = cost[0][color];

    for(int house = 1; house < n; house++)
    {
        for(int color = 0; color < k; color++)
        {
            int minCost = Integer.MAX_VALUE;
            for(int c = 0; c < k; c++)
            {
                if(c != color)
                    minCost = Math.min(minCost, dp[house - 1][c]);
            }

            dp[house][color] = minCost + cost[house][color];
        }
    }

    int ans = Integer.MAX_VALUE;
    for(int color = 0; color < k; color++)
        ans = Math.min(ans, dp[n - 1][color]);
    return ans;
}

// METHOD -> O(n^2)
public static int paintHouse2(int[][] cost){

    int n = cost.length; int k = cost[0].length;

    // dp[house][color] ->
    int[][] dp = new int[n][k];
    // trivial problem ->
    for(int color = 0; color < k; color++)
        dp[0][color] = cost[0][color];

    for(int house = 1; house < n; house++)
    {

        // Finding min and secMinCost cost for the previous HOUSES painted for the last respective color
        int minCost = Integer.MAX_VALUE;
        int secondMin = Integer.MAX_VALUE;
        for(int color = 0; color < k; color++)
        {
            if(dp[house - 1][color] <= minCost){
                secondMin = minCost;
                minCost = dp[house - 1][color];

            }else if(dp[house - 1][color] <= secondMin){
                secondMin = dp[house - 1][color];
            }
        }

        // Filling the dp array for the current house
        for(int color = 0; color < k; color++)
        {
            if(dp[house - 1][color] == minCost)
                dp[house][color] = secondMin + cost[house][color];
            else
                dp[house][color] = minCost + cost[house][color];
        }
    }

    int ans = Integer.MAX_VALUE;
    for(int color = 0; color < k; color++)
        ans = Math.min(ans, dp[n - 1][color]);
    return ans;
}

// int[][] cost = new int[n][k];
// for(int i = 0; i < n; i++)
// {
//     for(int j = 0; j < k; j++)
//         cost[i][j] = scn.nextInt();
// }

// System.out.println(paintHouse(cost));
