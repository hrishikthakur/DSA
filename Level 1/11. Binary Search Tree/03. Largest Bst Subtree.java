public static class largestPair {
  int min = Integer.MAX_VALUE;
  int max = Integer.MIN_VALUE;
  boolean isBST = true;
  int count = 0; // left aur right se BSTSubtree count mangvane k liye
}

static int maxCount = 0;
static Node largestBSTNode = null;
public static largestPair largestBSTSubtree(Node node) {
  if (node == null) return new largestPair();

  largestPair left = largestBSTSubtree(node.left);
  largestPair right = largestBSTSubtree(node.right);

  largestPair curr = new largestPair();
  curr.count = left.count + right.count + 1;
  if (left.max < node.data && node.data < right.min && left.isBST && right.isBST) {

    curr.isBST = true;
    if (curr.count > maxCount) {
      maxCount = curr.count;
      largestBSTNode = node;
    }

  } else {
    curr.isBST = false;
  }

  curr.min = Math.min(left.min, node.data);
  curr.max = Math.max(right.max, node.data);

  return curr;
}
