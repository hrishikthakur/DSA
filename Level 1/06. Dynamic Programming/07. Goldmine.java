// ************************************ Memoization ************************************

public static int goldmine(int r, int c, int[][] arr, int[][] dp) {

    // -ve base case -> Out of upper wall || lower wall
    if (r < 0 || r >= arr.length ) return Integer.MIN_VALUE;
    // +ve base case -> Reaches the right wall
    if (c == arr[0].length - 1) return arr[r][c];

    if (dp[r][c] != -1) return dp[r][c];

    int up = goldmine(r - 1, c + 1, arr, dp);
    int right = goldmine(r, c + 1, arr, dp);
    int down = goldmine(r + 1, c + 1, arr, dp);

    // ans = apni value + Calls ka max
    int ans = arr[r][c] + Math.max(up, Math.max(right, down));

    dp[r][c] = ans;
    return ans;
}

// int[][] dp = new int[n][m];
// for (int i = 0; i < n; i++)
//     Arrays.fill(dp[i], -1);

// int ans = 0;
// for (int i = 0; i < n; i++) {
//     ans = Math.max(ans, goldmine(i, 0, arr, dp));
// }

// System.out.println(ans);

// ************************************ Tabulation ************************************

public static int goldmineTab(int[][] arr) {

    int n = arr.length, m = arr[0].length;
    int[][] dp = new int[n][m];

    for (int j = m - 1; j >= 0; j--) {
        for (int i = 0; i < n; i++) {
            if (j == m - 1) {
                // if rightmost colomn
                dp[i][j] = arr[i][j];

            } else {
                int up = (i - 1 >= 0) ? dp[i - 1][j + 1] : Integer.MIN_VALUE;
                int right = dp[i][j + 1];
                int down = (i + 1 < n) ? dp[i + 1][j + 1] : Integer.MIN_VALUE;

                dp[i][j] = arr[i][j] + Math.max(up, Math.max(right, down));
            }
        }
    }
    int ans = Integer.MIN_VALUE;
    for (int i = 0; i < n; i++) {
        ans = Math.max(ans, dp[i][0]);
    }
    return ans;
}

// System.out.println(goldmineTab(arr));
