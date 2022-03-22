// Method 1 -> Without using parent node
public static void printSingleChildNodes(Node node) {
  if (node == null) return;
  if (node.left == null && node.right == null) {
    // leaf node
    return;
  }

  if (node.left == null) {
    // right ko print karva do
    // because we have already checked if both left and right are null
    // directy print node.right
    System.out.println(node.right.data);
  }
  if (node.right == null) {
    // print left
    System.out.println(node.left.data);
  }

  printSingleChildNodes(node.left);
  printSingleChildNodes(node.right);
}

// Method 2 -> Node par kadhe hokar check kar rahe hai kya vo single child hai ?
public static void printSingleChildNodes(Node node, Node parent) {
  if (node == null) return;

  if (parent != null && parent.left == null) {
    System.out.println(node.data);
  }
  if (parent != null && parent.right == null) {
    System.out.println(node.data);
  }
  printSingleChildNodes(node.left, node);
  printSingleChildNodes(node.right, node);
}

// Method 3 -> Using XOR
// Returns 0 when both are (0 || 1)
public static void printSingleChildNodes(Node node) {
  if (node == null) return;

  if ((node.left == null) ^ (node.right == null)) {
    if (node.left == null)
      System.out.println(node.right.data);
    else System.out.println(node.left.data);
  }

  printSingleChildNodes(node.left);
  printSingleChildNodes(node.right);
}
