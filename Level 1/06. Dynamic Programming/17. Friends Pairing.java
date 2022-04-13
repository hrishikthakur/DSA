// ************************************ Memoization ************************************

// Extra calls will be made here as
// we already know the count from (n - 2) call
public static int fpMemo1(int n, int[] dp) {
     if (n == 0 || n == 1) return 1;

     if (dp[n] != -1) return dp[n];

     int ans = fpMemo1(n - 1, dp);
     for (int i = 0; i < n - 1; i++) {
          ans += fpMemo1(n - 2, dp);
     }

     dp[n] = ans;
     return dp[n];
}

// To avoid extra calls
public static int fpMemo(int n, int[] dp) {
     if (n == 0 || n == 1) return 1;

     if (dp[n] != -1) return dp[n];

     int single = fpMemo(n - 1, dp);
     int pair = (n - 1) * fpMemo(n - 2, dp);

     dp[n] = single + pair;
     return dp[n];
}

// int[] dp = new int[n + 1];
// Arrays.fill(dp, -1);
// System.out.println(fpMemo(n, dp));

// ************************************ Tabulation ************************************

public static int fpTab(int n) {
     int[] dp = new int[n + 1];
     dp[0] = 1; dp[1] = 1;

     for (int i = 2; i <= n; i++) {
          dp[i] = dp[i - 1] + (i - 1) * dp[i - 2];
     }

     return dp[n];
}

// System.out.println(fpTab(n));
