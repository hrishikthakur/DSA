import java.io.*;
import java.util.*;

public class Main {

  public static int precedence(char ch) {
    if (ch == '*' || ch == '/') return 2;
    else if (ch == '+' || ch == '-') return 1;
    return 0;
  }

  public static void performOp(Stack<String> postfix, Stack<String> prefix, char op) {
    String prefixB = prefix.pop();
    String prefixA = prefix.pop();
    prefix.push(op + prefixA + prefixB);

    String postfixB = postfix.pop();
    String postfixA = postfix.pop();
    postfix.push(postfixA + postfixB + op);
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String exp = br.readLine();

    Stack<Character> operator = new Stack<>();
    Stack<String> postfix = new Stack<>();
    Stack<String> prefix = new Stack<>();

    for (int i = 0; i < exp.length(); i++) {
      char ch = exp.charAt(i);

      if (ch >= 'a' && ch <= 'z') {
        // push ch as a string
        postfix.push(ch + "");
        prefix.push(ch + "");
      }

      else if (ch == '(')
        operator.push(ch);

      else if (ch == ')') {
        while (operator.peek() != '(') {
          char op = operator.pop();
          performOp(postfix, prefix, op);
        }
        operator.pop(); // pop opening braces as well
      }

      else if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
        while (operator.size() > 0 && operator.peek() != ')' && precedence(operator.peek()) >= precedence(ch)) {
          char op = operator.pop();
          performOp(postfix, prefix, op);
        }
        operator.push(ch);
      }

    }

    while (operator.size() > 0) {
      char op = operator.pop();
      performOp(postfix, prefix, op);
    }

    System.out.println(postfix.peek());
    System.out.println(prefix.peek());

  }
}
