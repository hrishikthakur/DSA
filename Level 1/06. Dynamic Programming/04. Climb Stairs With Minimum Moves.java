// ************************************ Recursion ************************************

public static int csmmRec(int src, int dest, int[] arr) {
    // -ve base case -> 10 se 9 aane me infinte no. of steps lagenge
    if (src > dest) return Integer.MAX_VALUE;
    // +ve base case -> min moves to move from dest to dest -> 0
    if (src == dest) return 0;

    int minMoves = Integer.MAX_VALUE;
    for (int jumps = 1; jumps <= arr[src]; jumps++) {
        int ans = csmmRec(src + jumps, dest, arr);
        if (ans != Integer.MAX_VALUE)
            minMoves = Math.min(ans + 1, minMoves);
    }
    return minMoves;
}

// System.out.println(csmmRec(0, n - 1, arr));

// ************************************ Memoization ************************************

// dp array is the passed as an additional parameter for the recursive prototype

public static int csmmMem(int src, int dest, int[] arr, int[] dp) {
    // -ve base case -> 10 se 9 aane me infinte no. of steps lagenge
    if (src > dest) return Integer.MAX_VALUE;
    // +ve base case -> min moves to move from dest to dest -> 0
    if (src == dest) return 0;

    if (dp[src] != -1) return dp[src];

    int minMoves = Integer.MAX_VALUE;
    for (int jumps = 1; jumps <= arr[src]; jumps++) {
        int ans = csmmMem(src + jumps, dest, arr, dp);
        if (ans != Integer.MAX_VALUE)
            minMoves = Math.min(ans + 1, minMoves);
    }

    dp[src] = minMoves;
    return minMoves;
}

// System.out.println(csmmMem(0, n - 1, arr, dp));

// ************************************ Tabulation ************************************

public static int csmmTab(int[] jumps) {
    int n = jumps.length;

    // dp[i] will store min no. of moves from i to the last stair
    int[] dp = new int[n];
    Arrays.fill(dp, Integer.MAX_VALUE);
    dp[n - 1] = 0;

    for (int i = n - 2; i >= 0; i--) {
        int nOfJumps = jumps[i];
        if (nOfJumps == 0) {
            // It will take infinte no. of steps to reach the target step
            // Array is already filled with
            continue;
        }
        for (int jumpSize = 1; jumpSize <= nOfJumps; jumpSize++) {
            if (i + jumpSize <= n - 1) {
                // the stair we reached after the jumping must not take infinte steps to reach the target stair
                if (dp[i + jumpSize] != Integer.MAX_VALUE) {
                    int currMin = 1 + dp[i + jumpSize];
                    dp[i] = Math.min(currMin, dp[i]);
                }
            }
        }
    }
    return dp[0];
}

// System.out.println(csmmTab(arr));
