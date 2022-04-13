// ************************************ Memoization ************************************

// Note that there is only 1 varying variables -> cap
// Hence in tabulation a 1-D dp is required

public static int ubkMemo(int cap, int[] profits, int[] weights, int[] dp) {
     if (cap == 0) return 0;
     if (cap < 0) return Integer.MIN_VALUE;

     if (dp[cap] != -1) return dp[cap];

     int maxProfit = 0;
     for (int i = 0; i < weights.length; i++) {
          int currProfit = profits[i] + ubkMemo(cap - weights[i], profits, weights, dp);
          maxProfit = Math.max(maxProfit, currProfit);
     }

     dp[cap] = maxProfit;
     return dp[cap];
}

// int[] dp = new int[cap + 1];
// Arrays.fill(dp, -1);
// System.out.println(ubkMemo(cap, profits, weights, dp));

// ************************************ Tabulation ************************************
public static int ubkTab(int cap, int[] profits, int[] weights) {

     // dp[i] => maxProfit when cap = i with repetion of weights allowed
     int[] dp = new int[cap + 1];
     dp[0] = 0; // when cap = 0, maxProfit = 0;

     for (int currCap = 0; currCap <= cap; currCap++)
     {
          for (int j = 0; j < profits.length; j++)
          {
               int remainingCap = currCap - weights[j];
               if (remainingCap >= 0) {
                    // totalProfit = abhi added weight ka profit + the remainingCap ka maximum profit
                    int totalProfit = profits[j] + dp[remainingCap];
                    dp[currCap] = Math.max(dp[currCap], totalProfit);
               }
          }
     }
     return dp[cap];
}

// System.out.println(ubkTab(cap, profits, weights));
