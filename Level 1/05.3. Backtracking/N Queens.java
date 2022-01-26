import java.io.*;
import java.util.*;

public class Main {

  public static void main(String[] args) throws Exception {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    // int[][] chess = new int[n][n];
    boolean[][] chess = new boolean[n][n];
    printNQueens(chess, "", 0);
  }

  public static boolean isQueenSafe(boolean chess[][], int row, int col) {
    // check upward col
    int i = row - 1;
    while (i >= 0) {
      if (chess[i][col] == true) {
        return false;
      }
      i--;
    }
    // check upward left diagonal
    int r = row;
    int c = col;
    while (r >= 0 && c >= 0) {
      if (chess[r][c] == true) {
        return false;
      }
      r--;
      c--;
    }
    // check upward right diagonal
    r = row;
    c  = col;
    while (r >= 0 && c < chess[0].length) {
      if (chess[r][c] == true) {
        return false;
      }
      r--;
      c++;
    }
    return true;
  }

  // queens placed so far -> qsf
  public static void printNQueens(boolean[][] chess, String qsf, int row) {
    if (row == chess.length) {
      System.out.println(qsf + ".");
      return;
    }
    for (int col = 0; col < chess[0].length; col++) {
      if (isQueenSafe(chess, row, col) == true) {
        chess[row][col] = true; // edgePre (queen ko bithana)
        printNQueens(chess, qsf + row + "-" + col + ", ", row + 1);
        chess[row][col] = false; // edgePost (queen ko hatana)
      }
    }
  }
}
