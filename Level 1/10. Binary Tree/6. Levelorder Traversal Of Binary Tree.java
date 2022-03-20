// Using counter variable
// TC -> O(N)
// SC -> O(Breadth) <- Extra Space queue
public static void levelOrder(Node node) {
  if (node == null) return;

  Queue<Node> q = new ArrayDeque<>();
  q.add(node);

  while (q.size() > 0) {
    int counter = q.size();

    while (counter > 0) {
      // remove
      Node poped = q.remove();
      // print
      System.out.print(poped.data + " ");
      // add all children to queue
      if (poped.left != null) q.add(poped.left);
      if (poped.right != null) q.add(poped.right);

      counter--;
    }
    System.out.println();
  }
}
