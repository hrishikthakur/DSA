// ************************************ Memoization ************************************

public static int maxSum(int[] arr, int idx, int lastTaken, int[][] dp) {
     if (idx == arr.length) return 0;

     if (dp[idx][lastTaken] != -1) return dp[idx][lastTaken];

     if (lastTaken == 1) {
          // if previous element has been taken
          // the current element has only one option
          // i.e, not to be taken
          int ans = maxSum(arr, idx + 1, 0, dp);
          dp[idx][lastTaken] = ans;
          return ans;
     }

     // else explore both the options
     int ansNo = maxSum(arr, idx + 1, 0, dp);
     int ansYes = arr[idx] + maxSum(arr, idx + 1, 1, dp);
     int ans = Math.max(ansNo, ansYes);
     dp[idx][lastTaken] = ans;
     return ans;
}

// int[][] dp = new int[n + 1][2];
// for (int i = 0; i <= n; i++)
//      Arrays.fill(dp[i], -1);
// System.out.println(maxSum(arr, 0, 0, dp));

// ************************************ Tabulation ************************************

public static int maxSumTab(int[] arr) {

     int n = arr.length;
     int[] lastTaken = new int[n];
     int[] lastNotTaken = new int[n];

     // lastTaken[i] = maxSum when arr[i] is taken
     lastTaken[0] = arr[0];
     // lastNotTaken[i] = maxSum when arr[i] is not taken
     lastNotTaken[0] = 0;

     for (int i = 1; i < n; i++) {
          // arr[i] must always be taken
          lastTaken[i] = arr[i] + lastNotTaken[i - 1];
          // arr[i] must not be taken
          lastNotTaken[i] = Math.max(lastTaken[i - 1], lastNotTaken[i - 1]);
     }

     return Math.max(lastTaken[n - 1], lastNotTaken[n - 1]);
}

// Space optimized
public static int maxSumTab(int[] arr) {

     int lastTaken = arr[0];
     int lastNotTaken = 0;

     for (int i = 1; i < arr.length; i++) {

          // if curr is taken then previous must not be taken
          int currTaken = lastNotTaken + arr[i];

          // if curr is not taken ->
          // (i) previous is taken
          // (ii) previous is not taken
          int currNotTaken = Math.max(lastTaken, lastNotTaken);

          lastTaken = currTaken;
          lastNotTaken = currNotTaken;
     }
     return Math.max(lastTaken, lastNotTaken);
}

// System.out.println(maxSumTab(arr));
