public static class balancedPair {
  // is working for int height = -1;
  int height = 0;
  boolean isBal = true;
}

public static balancedPair isBalanced(Node node) {
  if (node == null) return new balancedPair();

  balancedPair left = isBalanced(node.left);
  balancedPair right = isBalanced(node.right);

  // ab root node k liye kaam karte hai
  // Postorder
  balancedPair curr = new balancedPair();
  if (left.isBal && right.isBal && Math.abs(left.height - right.height) <= 1) {
    curr.isBal = true;
  } else {
    curr.isBal = false;
  }
  curr.height = Math.max(left.height, right.height) + 1;
  return curr;
}
