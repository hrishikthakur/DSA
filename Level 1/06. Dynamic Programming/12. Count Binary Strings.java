
// ************************************ Tabulation ************************************

public static int countBinary(int n) {

     int[] endwith0 = new int[n + 1];
     int[] endwith1 = new int[n + 1];

     // no. of strings of length 1 ending with 0 and 1 = 1
     endwith0[1] = endwith1[1] = 1;

     for (int i = 2; i <= n; i++) {
          endwith0[i] = endwith1[i - 1];
          endwith1[i] = endwith0[i - 1] + endwith1[i - 1];
     }

     return endwith0[n] + endwith1[n];
}

// Space optimized solution -> Yaha dikh jaega fibonacci
public static int countBinary(int n) {

     int prev0 = 1;
     int prev1 = 1;

     for (int currLength = 2; currLength <= n; currLength++) {
          int curr0 = prev1;
          int curr1 = prev0 + prev1;

          prev0 = curr0;
          prev1 = curr1;
     }

     return prev0 + prev1;
}
