import java.io.*;
import java.util.*;

public class Main {

  public static void main(String[] args) throws Exception {

    Scanner scn = new Scanner(System.in);
    String input = scn.next();
    printSS(0, input, "");

  }

  public static void printSS(int idx, String str, String output) {

    if (idx == str.length()) {
      System.out.println(output);
      return;
    }

    printSS(idx + 1, str, output + str.charAt(idx)); //YES
    printSS(idx + 1, str, output); //NO
  }

}
