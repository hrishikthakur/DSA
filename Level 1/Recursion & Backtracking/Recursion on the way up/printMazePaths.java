import java.io.*;
import java.util.*;

public class Main {

  public static void main(String[] args) throws Exception {
    Scanner s = new Scanner(System.in);
    int n = s.nextInt();
    int m = s.nextInt();
    printMazePaths(0, 0, n - 1, m - 1, "");
  }

  // sr - source row
  // sc - source column
  // dr - destination row
  // dc - destination column
  public static void printMazePaths(int sr, int sc, int dr, int dc, String psf) {

    // positive base case
    if (sr == dr && sc == dc) {
      System.out.println(psf);
      return;
    }
    // negative base case
    if (sr > dr || sc > dc) {
      return;
    }

    // horizontal
    printMazePaths(sr, sc + 1, dr, dc, psf + "h");

    // vertical
    printMazePaths(sr + 1, sc, dr, dc, psf + "v");

  }

}
