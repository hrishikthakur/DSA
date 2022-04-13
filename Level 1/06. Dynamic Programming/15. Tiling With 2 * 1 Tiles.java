// ************************************ Memoization ************************************

public static int tiling(int n, int[] dp) {
     if (n == 1) return 1;
     if (n == 2) return 2;

     if (dp[n] != -1) return dp[n];
     int horizontal = tiling(n - 2, dp);
     int vertical = tiling(n - 1, dp);

     dp[n] = horizontal + vertical;
     return dp[n];
}

// int[] dp = new int[n + 1];
// Arrays.fill(dp, -1);
// System.out.println(tiling(n, dp));
