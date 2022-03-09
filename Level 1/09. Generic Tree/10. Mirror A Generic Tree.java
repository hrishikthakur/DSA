// Method 1 -> Using Collection framework
public static void mirror(Node node) {
  if (node == null) return;

  // Faith
  for (Node child : node.children)
    mirror(child);
  // Meeting Expectation - > Can be done in both preorder and postorder
  Collections.reverse(node.children);
}

// Method 2 -> Create own function to reverse an ArrayList
public static void reverse(ArrayList<Node> children) {
  int i = 0;
  int j = children.size() - 1;
  while (i < j) {
    Node left = children.get(i);
    Node right = children.get(j);
    children.set(i, right);
    children.set(j, left);
    i++; j--;
  }
}

public static void mirror(Node node) {
  if (node == null) return;

  for (Node child : node.children)
    mirror(child);
  // postorder (NOTE: Can be done in both postorder and preorder)
  reverse(node.children);
}
