public static void print(Node node) {

  if (node.left != null) System.out.print(node.left.data);
  else System.out.print(".");

  System.out.print(" <- " + node.data + " -> ");

  if (node.right != null) System.out.print(node.right.data);
  else System.out.print(".");

  System.out.println();
}

public static void display(Node node) {
  if (node == null) return;

  print(node);

  // Preorder
  display(node.left);
  // Inorder
  display(node.right);
  // Postorder
}
