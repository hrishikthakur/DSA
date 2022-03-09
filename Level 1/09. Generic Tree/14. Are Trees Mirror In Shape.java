public static boolean areMirror(Node n1, Node n2) {
  if (n1.children.size() != n2.children.size()) return false;

  // two trees areMirror if the have list same list(children) size
  for (int i = 0; i < n1.children.size(); i++) {
    Node c1 = n1.children.get(i);
    // for the second tree check children.size in reverse order, i.e, children.size() - 1 - i
    Node c2 = n2.children.get(n2.children.size() - 1 - i);
    boolean ans = areMirror(c1, c2);
    if (ans == false) return false;
  }
  return true;
}
