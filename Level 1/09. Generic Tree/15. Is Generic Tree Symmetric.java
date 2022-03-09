public static boolean isMirror(Node n1, Node n2) {
  if (n1.children.size() != n2.children.size()) return false;

  for (int i = 0; i < n1.children.size(); i++) {
    Node c1 = n1.children.get(i);
    Node c2 = n2.children.get(n2.children.size() - 1 - i);
    boolean ans = isMirror(c1, c2);
    if (ans == false) return false;
  }
  return true;
}

// check isMirror() passing the same node
// Symmetric if tree is mirror of itself
public static boolean IsSymmetric(Node node) {
  return isMirror(node, node);
}
