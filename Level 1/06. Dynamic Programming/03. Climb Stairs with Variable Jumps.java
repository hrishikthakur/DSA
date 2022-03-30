// ************************************ Recursion ************************************

public static int csvjRec(int src, int dest, int[] arr) {
    // -ve base case
    if (src > dest) return 0;
    // +ve base case
    if (src == dest) return 1;

    int totalPaths = 0;
    // Keeping recursion tree in mind ... calls laga do
    for (int jumps = 1; jumps <= arr[src]; jumps++) {
        int xi = csvjRec(src + jumps, dest, arr);
        totalPaths += xi;
    }

    return totalPaths;
}

// ************************************ Memoization ************************************

public static int csvjMem(int src, int dest, int[] arr, int[] dp) {
    // -ve base case
    if (src > dest) return 0;
    // +ve base case
    if (src == dest) return 1;

    // call lagane se pehle check if already calculated
    if (dp[src] != -1) return dp[src];

    int totalPaths = 0;
    for (int jumps = 1; jumps <= arr[src]; jumps++) {
        int xi = csvjMem(src + jumps, dest, arr, dp);
        totalPaths += xi;
    }

    // return karne se pehle -> store in dp table
    dp[src] = totalPaths;
    return dp[src];
}

public static void main(String[] args) throws Exception {
    // Scanner scn = new Scanner(System.in);
    // int n = scn.nextInt();

    // int[] arr = new int[n];
    // for (int i = 0; i < n; i++)
    //     arr[i] = scn.nextInt();

    int[] dp = new int[n + 1];
    Arrays.fill(dp, -1);
    System.out.println(csvjMem(0, n, arr, dp));
}

// ************************************ Tabulation ************************************

public static int csvjTab(int dest, int[] arr) {
    int n = arr.length;
    int[] dp = new int[n + 1];

    // targetStair se targetStair jana k paths => 1
    dp[dest] = 1;

    for (int i = arr.length - 1; i >= 0; i--) {

        int totalPaths = 0;
        for (int jumps = 1; jumps <= arr[i]; jumps++) {

            // dp.length - 1 is the target stair
            // dp array is 1 greater than the input array
            if (i + jumps < dp.length) {
                // dp[x] me padha hai x se targetStair takk jaane k paths
                totalPaths += dp[i + jumps];
            }
        }
        dp[i] = totalPaths;
    }
    return dp[0];
}
