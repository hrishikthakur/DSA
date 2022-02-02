import java.io.*;
import java.util.*;

public class Main {

  public static boolean isBalanced(String input) {

    Stack<Character> stk = new Stack<Character>();
    for (int i = 0; i < input.length(); i++) {

      char ch = input.charAt(i);

      if (ch == '[' || ch == '{' || ch == '(')
        stk.push(ch);

      else if (ch == ']') {
        if (stk.size() == 0 || stk.peek() != '[') // check 2nd only if the 1st condition is TRUE
          return false;
        stk.pop();
      }

      else if (ch == '}') {
        if (stk.size() == 0 || stk.peek() != '{') // check 2nd only if the 1st condition is TRUE
          return false;
        stk.pop();
      }

      else if (ch == ')') {
        if (stk.size() == 0 || stk.peek() != '(') // check 2nd only if the 1st condition is TRUE
          return false;
        stk.pop();
      }
    }
    return (stk.size() == 0) ? true : false;
  }

  public static void main(String[] args) throws Exception {
    Scanner scn = new Scanner(System.in);
    String input = scn.nextLine();
    System.out.println(isBalanced(input));
  }

}
