// Method 1 -> Void return type
// Leaf k parent par khadhe hokar leaf ko delete kar rahe hai
// Edge case -> Won't work if root node itself is a leaf node
public static void removeLeaves(Node node) {
  if (node == null) return;

  // agar left node exist karta hai
  if (node.left != null) {
    // check if kya vo leaf node hai
    // notice how we are checking [node.left != null] before writing node.left.left
    if (node.left.left == null && node.left.right == null) {
      // han leaf node
      node.left = null;
    } else {
      // agar leaf node nhi hai toh uspar call removeLeaves
      removeLeaves(node.left);
    }
  }

  if (node.right != null) {
    if (node.right.left == null && node.right.right == null) {
      // leaf node
      node.right = null;
    } else {
      removeLeaves(node.right);
    }
  }

  // This will work too
  // removeLeaves(node.left);
  // removeLeaves(node.right);
}

// Method 2 ->
// Leaf par khadhe hokar leaf ko delete kar rahe honge
// Leaf par jaakar return kar rahe hai null
public static Node removeLeaves(Node node) {
  if (node == null) return null;

  if (node.left == null && node.right == null) {
    // leaf node
    return null;
  }

  Node leftChild = removeLeaves(node.left);
  Node rightChild = removeLeaves(node.right);

  node.left = leftChild;
  node.right = rightChild;

  return node;
}
