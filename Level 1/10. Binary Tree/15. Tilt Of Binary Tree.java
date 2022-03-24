static int tilt = 0;
public static int tilt(Node node) {
  if (node == null) return 0;

  int leftSum = tilt(node.left);
  int rightSum = tilt(node.right);

  int tiltAtNode = Math.abs(leftSum - rightSum);
  tilt += tiltAtNode;

  // return sum
  return leftSum + rightSum + node.data;
}
