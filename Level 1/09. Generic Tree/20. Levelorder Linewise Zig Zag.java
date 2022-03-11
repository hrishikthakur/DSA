// Method => Using 2 Stacks
public static void levelOrderLinewiseZZ(Node node) {
  Stack<Node> mainStk = new Stack<>();
  mainStk.push(node);

  int level = 0;
  while (mainStk.size() > 0) {

    Stack<Node> childStk = new Stack<>();
    while (mainStk.size() > 0) {
      Node poped = mainStk.pop();
      System.out.print(poped.data + " ");

      if (level % 2 == 0) {
        // How must the children of "even level" (think of root as the even level) be added to the stack
        // so that they are printed right to left??
        // Ans -> left to right;
        for (int i = 0; i < poped.children.size(); i++)
          childStk.push(poped.children.get(i));
      }

      else {
        for (int i = poped.children.size() - 1; i >= 0; i--)
          childStk.push(poped.children.get(i));
      }
    }
    level++;
    System.out.println();
    mainStk = childStk;
  }
}
