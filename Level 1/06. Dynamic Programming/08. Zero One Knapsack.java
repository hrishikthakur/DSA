// ************************************ Tabulation ************************************

public static int zok(int[] profit, int[] weights, int cap) {

    int n = profit.length;
    int[][] dp = new int[n + 1][cap + 1];

    // Which loop first?
    // dp table dry run will give the ans
    for (int i = 1; i <= n; i++) {

        for (int currCap = 1; currCap <= cap; currCap++) {

            int no = dp[i - 1][currCap];
            int yes = 0;
            int remainingCap = currCap - weights[i - 1];
            if (remainingCap >= 0) {
                // added weight ka profit + max profit obtained from remaining cap
                yes = profit[i - 1] + dp[i - 1][remainingCap];
            }
            dp[i][currCap] = Math.max(no, yes);
        }
    }

    return dp[n][cap];
}
