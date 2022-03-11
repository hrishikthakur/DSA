public static class Pair {
  Node node;
  int state;

  Pair(Node node, int state) {
    this.node = node;
    this.state = -1;
  }
}

public static void IterativePreandPostOrder(Node root) {
  ArrayList<Integer> preorder = new ArrayList<>();
  ArrayList<Integer> postorder = new ArrayList<>();

  Stack<Pair> stk = new Stack<>();
  Pair rootPair = new Pair(root, -1);
  stk.push(rootPair);

  while (stk.size() > 0) {

    Pair parent = stk.peek(); // peek not remove

    if (parent.state == -1) {
      // preorder
      preorder.add(parent.node.data);
      // edge pre me jaane k liye
      parent.state++;

    } else if (parent.state == parent.node.children.size()) {
      // postorder
      postorder.add(parent.node.data);
      stk.pop();

    } else {
      // 0 <= parent.state < parent.node.children.size()

      // edge
      Pair child = new Pair(parent.node.children.get(parent.state), -1);
      stk.push(child);
      // edge post
      parent.state++;
    }
  }

  for (Integer i : preorder)
    System.out.print(i + " ");

  System.out.println();
  for (Integer i : postorder)
    System.out.print(i + " ");
}
