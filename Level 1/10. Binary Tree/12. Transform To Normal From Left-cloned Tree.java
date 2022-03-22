public static Node transBackFromLeftClonedTree(Node node) {
  if (node == null) return null;

  // Faith
  // Notice that leaf node kabhi visit hoga hi nhi
  // hence the faith is valid w.r.t the base case that we have put
  Node leftRoot = transBackFromLeftClonedTree(node.left.left);
  Node rightRoot = transBackFromLeftClonedTree(node.right);

  // Meeting Expectataion
  node.left = leftRoot;
  return node;
}
