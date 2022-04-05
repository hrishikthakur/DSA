// ************************************ Recursion ************************************

public static int minCostRec(int sr, int sc, int dr, int dc, int[][] arr) {
    // -ve base case
    if (sc < 0 || sr < 0 || sc > dc || sr > dr) return Integer.MAX_VALUE;
    // +ve base case
    if (sr == dr && sc == dc) return arr[sr][sc];

    // horizontal
    int x = minCostRec(sr, sc + 1, dr, dc, arr);
    // vertical
    int y = minCostRec(sr + 1, sc, dr, dc, arr);

    return arr[sr][sc] + Math.min(x, y);
}

// minCostRec(0, 0, n - 1, m - 1, arr);

// ************************************ Memoization ************************************

public static int minCostMemo(int sr, int sc, int dr, int dc, int[][] arr, int[][] dp) {
    // -ve base case
    if (sc > dc || sr > dr) return Integer.MAX_VALUE;
    // +ve base case
    if (sr == dr && sc == dc) return arr[dr][dc];

    if (dp[sr][sc] != -1) return dp[sr][sc];

    // horizontal
    int x = minCostMemo(sr, sc + 1, dr, dc, arr, dp);
    // vertical
    int y = minCostMemo(sr + 1, sc, dr, dc, arr, dp);

    int ans = arr[sr][sc] + Math.min(x, y);

    dp[sr][sc] = ans;
    return ans;
}

// minCostMemo(0, 0, n - 1, m - 1, arr, dp);

// ************************************ Tabulation ************************************

public static int minCostTab(int[][] arr) {
    int n = arr.length, m = arr[0].length;
    int[][] dp = new int[n][m];

    for (int i = n - 1; i >= 0; i--) {
        for (int j = m - 1; j >= 0; j--) {

            if (i + 1 < n && j + 1 < m) {
                // Lies within the matrix
                dp[i][j] = arr[i][j] + Math.min(dp[i][j + 1], dp[i + 1][j]);
            } else if (i + 1 == n && j + 1 == m) {
                // Goes out of the last cell
                dp[i][j] = arr[i][j];
            } else if (i + 1 > n - 1) {
                // Goes out of the bottom wall
                dp[i][j] = arr[i][j] + dp[i][j + 1];
            } else if (j + 1 > m - 1) {
                // Goes out of the right wall
                dp[i][j] = arr[i][j] + dp[i + 1][j];
            }
        }
    }

    return dp[0][0];
}

// minCostTab(arr);
