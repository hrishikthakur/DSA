public static int size(Node node) {
  if (node == null) return 0;

  int leftSize = size(node.left);
  int rightSize = size(node.right);

  return leftSize + rightSize + 1;
}

public static int sum(Node node) {
  if (node == null) return 0;

  int leftSum = sum(node.left);
  int rightSum = sum(node.right);

  return leftSum + rightSum + node.data;
}

// Move as left as possible
public static int max(Node node) {
  if (node.right == null) return node.data;

  int max = max(node.right);
  return max;
}

// Move as left as possible
public static int min(Node node) {
  if (node.left == null) return node.data;

  int min = min(node.left);
  return min;
}

public static boolean find(Node node, int data) {
  if (node == null) return false;
  // +ve base case
  if (node.data == data) return true;

  boolean ans = false;
  if (data < node.data) {
    ans = find(node.left, data);
  } else {
    ans = find(node.right, data);
  }
  return ans;
}
