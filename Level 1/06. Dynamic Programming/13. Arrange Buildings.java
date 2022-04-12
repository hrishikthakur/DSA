// ************************************ Tabulation ************************************

// Map buildings to 0 and spaces to 1

public static long arrangeBuildings(int n) {
     long prev0 = 1l;
     long prev1 = 1l;

     for (int i = 2; i <= n; i++) {
          // agar prev 0 hai (building)
          // call will only be made for 1(space)
          long curr0 = prev1;
          // else make call for both buildings and spaces
          long curr1 = prev0 + prev1;

          prev0 = curr0;
          prev1 = curr1;
     }

     long ansOneSide = prev0 + prev1;
     return ansOneSide * ansOneSide;
}
