// ************************************ Memoization ************************************

public static int tiling(int n, int m, int[] dp) {
     if (n == 0 || n == 1) return 1;

     if (dp[n] != -1) return dp[n];

     int vertical = tiling(n - 1, m, dp);
     int horizontal = 0;
     // Horizontally kab place kar sakte hai?
     // Jab n >= m
     if (m <= n) {
          horizontal = tiling(n - m, m, dp);
     }

     dp[n] = vertical + horizontal;
     return dp[n];
}

// int[] dp = new int[n + 1];
// Arrays.fill(dp, -1);
// System.out.println(tiling(n, m, dp));
