// ************************************ Memoization ************************************

// Note that there are two varying variables -> idx & cap
// Hence in tabulation a 2-D dp is required

public static int zokMemo(int idx, int cap, int[] profits, int[] weights, int[][] dp) {
    // +ve base case
    if (idx == profits.length) return 0;

    if (dp[idx][cap] != -1) return dp[idx][cap];

    int yes = 0;
    if (cap - weights[idx] >= 0) {
        yes = profits[idx] + zokMemo(idx + 1, cap - weights[idx], profits, weights, dp);
    }
    int no = zokMemo(idx + 1, cap, profits, weights, dp);

    dp[idx][cap] = Math.max(yes, no);
    return dp[idx][cap];
}

// int n = weights.length;
// int[][] dp = new int[n + 1][cap + 1];
// for (int i = 0; i <= n; i++)
//     Arrays.fill(dp[i], -1);
// System.out.println(zokMemo(0, cap, profits, weights, dp));

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
