import java.io.*;
import java.util.*;

public class Main {

  public static void radixSort(int[] arr) {
    // 1,10,100,.... ye sequence generate krni hai
    int max = 0;
    for (int val : arr)
      max = Math.max(val, max);

    int digits = (int)Math.log10(max) + 1;
    int maxPlaceValue = (int)Math.pow(10, digits - 1);

    for (int i = 1; i <= maxPlaceValue; i *= 10) {
      countSort(arr, i);
    }
  }

  public static void countSort(int[] arr, int exp) {
    // write code here
    // Traversal 2 -> fill the frequency array
    int[] freq = new int[10];
    for (int i = 0; i < arr.length; i++) {
      int val = arr[i];
      int idx = (val / exp) % 10;
      freq[idx]++;
    }

    // Traversal 3 -> find prefix array (provide stability)
    int[] prefSum = new int[10];
    prefSum[0] = freq[0];
    for (int i = 1; i < freq.length; i++)
      prefSum[i] = prefSum[i - 1] + freq[i];
    // NOTE -> prefSum[i] represents the last index of corresponding element in the 1 base indexing

    // Traversal 4 -> Reverse travese the original "arr" and fill the values in the "res" array
    int[] res = new int[arr.length];
    for (int i = arr.length - 1; i >= 0; i--) {
      int val = arr[i];
      prefSum[(val / exp) % 10]--; // convert from 1 based indexing to 0 based indexing
      int idx = prefSum[(val / exp) % 10];
      res[idx] = val;

    }

    // Traversal 5 -> copy back into the original array
    for (int i = 0; i < res.length; i++) {
      arr[i] = res[i];
    }

    System.out.print("After sorting on " + exp + " place -> ");
    print(arr);
  }

  public static void print(int[] arr) {
    for (int i = 0; i < arr.length; i++) {
      System.out.print(arr[i] + " ");
    }
    System.out.println();
  }

  public static void main(String[] args) throws Exception {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int[] arr = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = scn.nextInt();
    }
    radixSort(arr);
    print(arr);
  }

}
