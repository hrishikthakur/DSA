// ************************************ Recursion ************************************

// My written code -> n se 0 takk jaana
public static int cs(int n) {
    // +ve base case
    if (n == 0) return 1;
    // -ve base case
    if (n == -1 || n == -2) return 0;

    int ans1 = cs(n - 1);
    int ans2 = cs(n - 2);
    int ans3 = cs(n - 3);

    return ans1 + ans2 + ans3;
}

// Archit sirs' -> 0 se n takk jana
public static int csRec(int src, int dest) {
    // -ve base case
    if (src > dest) return 0;
    // +ve base case
    if (src == dest) return 1;

    int x = csRec(src + 1, dest);
    int y = csRec(src + 2, dest);
    int z = csRec(src + 3, dest);

    int totalPaths = x + y + z;
    return totalPaths;
}

// ************************************ Memoization ************************************

public static int csMem(int src, int dest, int[] dp) {
    if (src > dest) return 0;
    if (src == dest) return 1;

    // call lagane se pehle check if already calculated
    if (dp[src] != -1) return dp[src];

    int x = csMem(src + 1, dest, dp);
    int y = csMem(src + 2, dest, dp);
    int z = csMem(src + 3, dest, dp);

    // return karne se pehle save
    dp[src] = x + y + z;
    return dp[src];
}

public static void main(String[] args) throws Exception {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();

    int[] dp = new int[n + 1];
    Arrays.fill(dp, -1);

    int ans = csMem(0, n, dp);
    System.out.println(ans);
}

// ************************************ Tabulation ************************************
public static int csTab(int src, int dest) {
    int[] dp = new int[dest + 1];

    // destination se destination jaane k paths = 1;
    dp[dest] = 1;

    // start from the second last element of the dp array
    // last element has already been set to 1
    for (int i = dest - 1; i >= 0; i--) {
        dp[i] = dp[i + 1];
        if (i + 2 < dp.length) {
            dp[i] += dp[i + 2];
        }
        if (i + 3 < dp.length) {
            dp[i] += dp[i + 3];
        }
    }

    return dp[0];
}
