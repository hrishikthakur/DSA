public static int size(Node root) {
  if (root == null) return 0;

  int sizeLeft = size(root.left);
  int sizeRight = size(root.right);
  return sizeLeft + sizeRight + 1;
}

public static int sum(Node root) {
  if (root == null) return 0;

  int sumLeft = sum(root.left);
  int sumRight = sum(root.right);
  return sumLeft + sumRight + root.data;
}

public static int max(Node root) {
  if (root == null) return Integer.MIN_VALUE;

  int leftMax = max(root.left);
  int rightMax = max(root.right);
  int temp = Math.max(leftMax, rightMax);
  return Math.max(temp, root.data);
}

// in terms of nodes
public static int height(Node root) {
  if (root == null) return 0;

  int leftHeight = height(root.left);
  int rightHeight = height(root.right);
  return 1 + Math.max(leftHeight, rightHeight);
}

// in terms of edges
public static int height(Node root) {
  if (root == null) return 0;

  int leftHeight = 0, rightHeight = 0;
  if (root.left != null) leftHeight = 1 + height(root.left);
  if (root.right != null) rightHeight = 1 + height(root.right);

  return Math.max(leftHeight, rightHeight);
}
