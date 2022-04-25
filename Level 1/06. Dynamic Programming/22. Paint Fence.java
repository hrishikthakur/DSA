// ************************************ Tabulation ************************************

public static void paintFence(int fences, int colors){

    int[][] dp = new int[2][fences];

    dp[0][1] = colors;
    dp[1][1] = colors * (colors - 1);

    for(int i=2; i<fences; i++)
    {
        // c1 == c2
        dp[0][i] = dp[1][i - 1];
        // c1 != c2
        dp[1][i] = (colors - 1) * (dp[0][i - 1] + dp[1][i - 1]);
    }

    System.out.println(dp[0][fences - 1] + dp[1][fences - 1]);
}

// Using 2 variables without the dp array
public static void paintFence1(int n, int k){

    // Trivial Case -> 2 fences
    int ii = k;
    int ij = k * (k - 1);

    for(int f = 2; f < n; f++){

        int newii = ij;
        int newij = (k - 1) * (ii + ij);

        ii = newii;
        ij = newij;

    }
    System.out.println(ii + ij);
}
