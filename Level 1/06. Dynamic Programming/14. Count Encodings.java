// ************************************ Memoisation ************************************
public static int countEncodingsMemo(int idx, String str, int[] dp) {

    // if(idx < str.length()) .. this case will never arise
    if (idx == str.length()) return 1;

    int ans = 0;

    if (dp[idx] != -1) return dp[idx];

    int ch1 = str.charAt(idx) - '0';
    if (ch1 >= 1 && ch1 <= 9) {
        ans += countEncodingsMemo(idx + 1, str, dp);
    }

    if (idx + 1 < str.length()) {
        int ch12 = (str.charAt(idx) - '0') * 10 + (str.charAt(idx + 1) - '0');
        if (ch12 >= 10 && ch12 <= 26)
            ans += countEncodingsMemo(idx + 2, str, dp);
    }

    dp[idx] = ans;
    return ans;
}

// int[] dp = new int[str.length()];
// Arrays.fill(dp, -1);
// System.out.println(countEncodingsMemo(0, str, dp));

// ************************************ Tabulation ************************************
public static int countEncodingsTab(String str) {

    // dp[i] => no. of encodings of string [i, str.length);
    int[] dp = new int[str.length() + 1];
    dp[str.length()] = 1;

    // should I iterate on the string or the dp array
    // yaha toh stirng par hi iterate kiya hai
    for (int i = str.length() - 1; i >= 0; i--) {
        int ch1 = str.charAt(i) - '0';
        if (ch1 >= 1 && ch1 <= 9)
            dp[i] += dp[i + 1];

        if (i + 1 < str.length()) {
            int ch12 = (str.charAt(i) - '0') * 10 + (str.charAt(i + 1) - '0');
            if (ch12 >= 10 && ch12 <= 26)
                dp[i] += dp[i + 2];
        }
    }
    return dp[0];
}

// System.out.println(countEncodingsTab(str));
