// ************************************ Recursion ************************************

public static long partitionKSubset(int n, int k) {
    // n -> people ; k -> rooms

    if(k == 1) return 1;
    if(k == 0) return 0;

    if(n == 0) return 0;
    if(n == k) return 1;
    if(n < k) return 0;

    long x = partitionKSubset(n - 1, k);
    long y = partitionKSubset(n - 1, k - 1);

    return x * k + y;
}

// ************************************ Memoization ************************************

public static long partitionKSubset(int n, int k, long[][] dp) {
    // n -> people ; k -> rooms

    if(k == 1) return 1;
    if(k == 0) return 0;

    if(n == 0) return 0;
    if(n == k) return 1;
    if(n < k) return 0;

    if(dp[n][k] != -1) return dp[n][k];

    long x = partitionKSubset(n - 1, k);
    long y = partitionKSubset(n - 1, k - 1);

    long ans = x * k + y;
    dp[n][k] = ans;
    return ans;
}

// long[][] dp = new long[n + 1][k + 1];
// for(int i = 0; i <= n; i++)
//     Arrays.fill(dp[i], -1);

// long res = partitionKSubset(n, k, dp);
// System.out.println(res);

// ************************************ Tabulation ************************************
