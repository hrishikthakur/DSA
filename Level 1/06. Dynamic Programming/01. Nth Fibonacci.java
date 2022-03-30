// ************************************ Recursion ************************************

public static int fibRec(int n) {
    if (n == 0 || n == 1) return n;

    int fibnm1 = fibRec(n - 1);
    int fibnm2 = fibRec(n - 2);
    int fibn = fibnm1 + fibnm2;

    return fibn;
}

// ************************************ Memoization ************************************

public static int fibMem(int n, int[] dp) {
    if (n == 0 || n == 1) return n;

    // Calls lagne se pehle
    if (dp[n] != -1) return dp[n];

    int fibnm1 = fibMem(n - 1, dp);
    int fibnm2 = fibMem(n - 2, dp);

    // calculate karne ke bad return karne se pehle
    dp[n] = fibnm1 + fibnm2;
    return dp[n];
}
public static void main(String[] args) throws Exception {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();

    // because nth index has the nth fibonacci
    int[] dp = new int[n + 1];
    Arrays.fill(dp, -1);
    System.out.println(fibMem(n, dp));
}

// ************************************ Tabulation ************************************

public static int fibTab(int n) {
    int[] dp = new int[n + 1];
    dp[0] = 0; dp[1] = 1;

    for (int i = 2; i <= n; i++) {
        dp[i] = dp[i - 1] + dp[i - 2];
    }

    return dp[n];
}
