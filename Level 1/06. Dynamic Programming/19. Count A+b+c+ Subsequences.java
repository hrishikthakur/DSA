// ************************************ Tabulation ************************************

public static int countSub(String str) {

     int n = str.length();
     int x = 0, y = 0, z = 0;

     for (int i = 1; i <= n; i++)
     {
          char ch = str.charAt(i - 1);
          int newX = x, newY = y, newZ = z;

          if (ch == 'a') {
               newX = (2 * x) + 1;

          } else if (ch == 'b') {
               newY = (2 * y) + x;

          } else if (ch == 'c') {
               newZ = (2 * z) + y;

          }

          x = newX; y = newY; z = newZ;
     }
     return z;
}
