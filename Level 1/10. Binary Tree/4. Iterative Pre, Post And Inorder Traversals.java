public static void iterativePrePostInTraversal(Node node) {
  ArrayList<Integer> preorder = new ArrayList<>();
  ArrayList<Integer> inorder = new ArrayList<>();
  ArrayList<Integer> postorder = new ArrayList<>();

  Stack<Pair> stk = new Stack<>();
  Pair rootPair = new Pair(node, -1);
  stk.push(rootPair);

  while (stk.size() > 0) {
    Pair parent = stk.peek();

    if (parent.state == -1) {
      // preorder
      preorder.add(parent.node.data);
      if (parent.node.left != null) stk.push(new Pair(parent.node.left, -1));
      parent.state++;

    } else if (parent.state == 0) {
      // inorder
      inorder.add(parent.node.data);
      if (parent.node.right != null) stk.push(new Pair(parent.node.right, -1));
      parent.state++;

    } else if (parent.state == 1) {
      // postorder
      postorder.add(parent.node.data);
      stk.pop();
    }

  }

  for (Integer i : preorder)
    System.out.print(i + " ");
  System.out.println();
  for (Integer i : inorder)
    System.out.print(i + " ");
  System.out.println();
  for (Integer i : postorder)
    System.out.print(i + " ");

}
