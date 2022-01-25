import java.io.*;
import java.util.*;

public class Main {

  public static void countSort(int[] arr, int min, int max) {
    //write your code here

    // Traversal 1 -> Find min element and max element
    // int min = Integer.MAX_VALUE;
    // int max = Integer.MIN_VALUE;
    // for(int i = 0; i<arr.length; i++){
    //     min = Math.min(min,arr[i]);
    //     max = Math.max(max, arr[i]);
    // }
    // System.out.println(min+" "+max);

    int[] freqArr = new int[(max - min) + 1];

    // Traversal 2 -> fill the frequency array
    for (int i = 0; i < arr.length; i++) {
      int currElement = arr[i];
      int idx = currElement - min;
      freqArr[idx]++;
    }

    // Traversal 3 -> Sort
    int count = 0;
    for (int i = 0; i < freqArr.length; i++) {

      int loop = freqArr[i];
      int toAddElement = i + min;
      while (loop > 0) {
        arr[count] = toAddElement;
        loop--;
        count++;
      }
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
