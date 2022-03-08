public static void removeLeaves(Node node) {
  // if (node == null) return;

  // Preorder -> so that
  // if done in postorder the entire tree will disappear except for the root
  for (int i = node.children.size() - 1; i >= 0; i--) {
    Node currChild = node.children.get(i);
    if (currChild.children.size() == 0) {
      // leaf node -> remove child
      node.children.remove(i);
    }
  }

  //
  for (Node child : node.children)
    removeLeaves(child);
}
