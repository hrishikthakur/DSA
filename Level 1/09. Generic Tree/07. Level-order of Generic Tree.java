public static void levelOrder(Node node) {
  if (node == null)
    return;

  Queue<Node> q = new ArrayDeque<>();
  q.add(node);

  // remove print addChildren
  while (q.size() > 0) {
    Node poped = q.remove();
    System.out.print(poped.data + " ");
    for (Node child : poped.children)
      q.add(child);
  }
  System.out.println(".");
}
