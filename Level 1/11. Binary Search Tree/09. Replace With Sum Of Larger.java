static int sum = 0;
public static void rwsol(Node node) {
  if (node == null) return;

  rwsol(node.right);
  int temp = node.data;
  // for the rightmost node(maximum node) sum is 0
  node.data = sum;
  sum += temp;
  rwsol(node.left);

  return;
}
