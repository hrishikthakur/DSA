public static boolean isDuplicate(String input) {
  Stack<Character> stk = new Stack<Character>();
  for (int i = 0; i < input.length(); i++) {
    char ch = input.charAt(i);
    if (ch == ')') {
      if (stk.peek() == '(') {
        // no independent content
        return true;
      }
      while (stk.peek() != '(')
        stk.pop();

      stk.pop(); // to pop '(' as it is balanced (GIVEN)
    } else
      stk.push(ch);
  }
  return false;
}
