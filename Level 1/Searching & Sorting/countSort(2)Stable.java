import java.io.*;
import java.util.*;

public class Main {

  public static void countSort(int[] arr, int min, int max) {

    // Traversal 1 -> Find min element and max element

    // Traversal 2 -> fill the frequency array
    int[] freq = new int[(max - min) + 1];
    for (int i = 0; i < arr.length; i++) {
      int val = arr[i];
      int idx = val - min;
      freq[idx]++;
    }

    // Traversal 3 -> find prefix array (provide stability)
    int[] prefSum = new int[max - min + 1];
    prefSum[0] = freq[0];
    for (int i = 1; i < freq.length; i++)
      prefSum[i] = prefSum[i - 1] + freq[i];
    // NOTE -> prefSum[i] represents the last index of corresponding element in the 1 base indexing

    // Traversal 4 -> Reverse travese the original "arr" and fill the values in the "res" array
    int[] res = new int[arr.length];
    for (int i = arr.length - 1; i >= 0; i--) {
      int val = arr[i];
      prefSum[val - min]--; // convert from 1 based indexing to 0 based indexing
      int idx = prefSum[val - min];
      res[idx] = val;

    }

    // Traversal 5 -> copy back into the original array
    for (int i = 0; i < res.length; i++) {
      arr[i] = res[i];
    }

  }

  public static void print(int[] arr) {
    for (int i = 0; i < arr.length; i++) {
      System.out.println(arr[i]);
    }
  }

  public static void main(String[] args) throws Exception {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int[] arr = new int[n];
    int max = Integer.MIN_VALUE;
    int min = Integer.MAX_VALUE;
    for (int i = 0; i < n; i++) {
      arr[i] = scn.nextInt();
      max = Math.max(max, arr[i]);
      min = Math.min(min, arr[i]);
    }
    countSort(arr, min, max);
    print(arr);
  }

}
