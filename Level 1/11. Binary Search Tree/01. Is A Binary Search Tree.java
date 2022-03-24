// Method 1 -> Postorder
// returning min, max, isBST
public static class isBSTPair {
  int min = Integer.MAX_VALUE;
  int max = Integer.MIN_VALUE;
  boolean isBST = true; // tree hi nhi hai toh BST toh hoga hi

}

public static isBSTPair isBST(Node node) {
  if (node == null) return new isBSTPair();

  isBSTPair left = isBST(node.left);
  isBSTPair right = isBST(node.right);

  // POSTORDER

  isBSTPair curr = new isBSTPair();
  if (left.max < node.data && node.data < right.min && left.isBST && right.isBST) {
    curr.isBST = true;
  } else {
    curr.isBST = false;
  }

  curr.max = Math.max(node.data, Math.max(left.max, right.max));
  curr.min = Math.min(node.data, Math.min(left.min, right.min));

  // This will work too
  // curr.max = Math.max(node.data, right.max);
  // curr.min = Math.min(node.data, left.min);

  return curr;
}

// Method 2 -> Preorder
public static boolean isBST(Node node, int min, int max) {
  if (node == null) return true;

  if (node.data > min && node.data < max) {
    boolean left = isBST(node.left, min, node.data);
    boolean right = isBST(node.right, node.data, max);
    return left && right;
  }

  return false;
}

// main()
System.out.println(isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE));

// Method 3 -> O(n * n)
// Poor approach
public static boolean isBST(Node node) {
  if (node == null) return true;

  boolean left = isBST(node.left);
  boolean right = isBST(node.right);

  int leftMax = max(node.left);
  int rightMin = min(node.right);

  if (leftMax < node.data && node.data < rightMin && left && right) {
    return true;
  }
  return false;
}
