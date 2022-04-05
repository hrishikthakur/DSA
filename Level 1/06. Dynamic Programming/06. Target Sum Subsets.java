// ************************************ Recursion ************************************

public static boolean targetSum(int arr[], int idx, int currSum, int target) {
    if (idx == arr.length) {
        if (currSum == target) return true;
        return false;
    }

    // pruning step
    if (currSum > target) return false;

    boolean yes = targetSum(arr, idx + 1, currSum + arr[idx], target);
    boolean no = targetSum(arr, idx + 1, currSum, target);

    return (yes == true || no == true) ? true : false;
}

// targetSum(arr, 0, 0, target);

// ************************************ Memoization ************************************

public static boolean targetSumMemo(int arr[], int idx, int currSum, int target, int[][] dp) {
    if (idx == arr.length) {
        if (currSum == target) return true;
        return false;
    }

    // pruning step
    if (currSum > target) return false;

    if (dp[idx][currSum] != -1) return (dp[idx][currSum] == 1) ? true : false;

    boolean yes = targetSumMemo(arr, idx + 1, currSum + arr[idx], target, dp);
    boolean no = targetSumMemo(arr, idx + 1, currSum, target, dp);

    if (yes == true || no == true) {
        dp[idx][currSum] = 1;
        return true;
    } else {
        dp[idx][currSum] = 0;
        return false;
    }
}

// n = arr.length
// int[][] dp = new int[n + 1][target + 1];
// for (int i = 0; i <= n; i++)
//     Arrays.fill(dp[i], -1);
// System.out.println(targetSumMemo(arr, 0, 0, target, dp));

// ************************************ Tabulation ************************************

public static boolean targetSumTab(int[] arr, int target) {

    int n = arr.length;
    boolean[][] dp = new boolean[n + 1][target + 1];

    // 0th coloumn = true
    for (int i = 0; i <= n; i++) {
        dp[i][0] = true;
    }

    for (int i = 1; i <= n; i++) {

        for (int j = 1; j <= target; j++) {

            boolean no = dp[i - 1][j];
            boolean yes = (j - arr[i - 1] < 0) ? false : dp[i - 1][j - arr[i - 1]];

            dp[i][j] = no || yes;
        }
    }
    return dp[n][target];
}

// System.out.println(targetSumTab(arr, target));
