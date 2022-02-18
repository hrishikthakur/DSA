import java.io.*;
import java.util.*;

public class Main {

  public static int perfomOp(int a, char op, int b) {
    if (op == '+') return a + b;
    else if ( op == '-') return a - b;
    else if (op == '*') return a * b;
    else return a / b;
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String exp = br.readLine();

    Stack<Integer> evaluation = new Stack<>();
    Stack<String> infix = new Stack<>();
    Stack<String> prefix = new Stack<>();

    for (int i = 0; i < exp.length(); i++) {
      char ch = exp.charAt(i);

      if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {

        // evaluation Stack
        int valB = evaluation.pop();
        int valA = evaluation.pop();
        evaluation.push(perfomOp(valA, ch, valB));

        // Infix Stack
        String infixB = infix.pop();
        String infixA = infix.pop();
        infix.push("(" + infixA + ch + infixB + ")");

        // prefix Stack
        String prefixB = prefix.pop();
        String prefixA = prefix.pop();
        prefix.push(ch + prefixA + prefixB);

      } else {
        evaluation.push(ch - '0');
        infix.push(ch + "");
        prefix.push(ch + "");
      }
    }

    System.out.println(evaluation.peek());
    System.out.println(infix.peek());
    System.out.println(prefix.peek());
  }
}
