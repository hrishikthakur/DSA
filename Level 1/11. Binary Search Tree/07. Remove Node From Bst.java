public static Node remove(Node node, int data) {
  if (node == null) {
    // node does not exist
    return null;
  }

  // 3 cases ban sakte hai

  if (node.data == data) {

    if (node.left == null && node.right == null) {
      // leaf node
      return null;
    } else if (node.left == null) {
      // has only right child
      return node.right;

    } else if (node.right == null) {
      // has only left child
      return node.left;

    } else {
      // has 2 children
      int inorderPredecessor = max(node.left);
      node.data = inorderPredecessor;
      node.left = remove(node.left, inorderPredecessor);

    }

  } else if (data < node.data) {
    node.left = remove(node.left, data);

  } else {
    node.right = remove(node.right, data);
  }

  return node;
}
