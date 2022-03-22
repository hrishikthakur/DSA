public static Node createLeftCloneTree(Node node) {
  if (node == null) return null;

  // Faith
  Node leftRoot = createLeftCloneTree(node.left);
  Node rightRoot = createLeftCloneTree(node.right);

  // Meeting Expectation
  Node copyNode = new Node(node.data);
  copyNode.left = leftRoot;
  node.left = copyNode;

  return node;
}
