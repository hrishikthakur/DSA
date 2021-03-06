import java.io.*;
import java.util.*;

public class Main {

  public static void main(String[] args) throws Exception {

    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int[] arr = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = scn.nextInt();
    }
    int target = scn.nextInt();
    printTargetSumSubsets(arr, 0, "", target);

  }

  // set is the subset
  // sos is sum of subset
  // tar is target
  public static void printTargetSumSubsets(int[] arr, int idx, String set, int remTarget) {

    if (idx == arr.length) {
      if (remTarget == 0) {
        System.out.println(set + '.');
      }
      return;
    }

    // pruning step -> Trimming unnecessary branches
    // if(remTarget < 0){
    //     return;
    // }

    // yes
    if (remTarget >= 0) {
      printTargetSumSubsets(arr, idx + 1, set + arr[idx] + ", ", remTarget - arr[idx]);
    }
    // no
    printTargetSumSubsets(arr, idx + 1, set, remTarget);
  }

}
