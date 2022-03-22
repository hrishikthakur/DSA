public static void printKLevelsDown(Node node, int k) {
  // -ve base case
  if (node == null || k < 0) return;
  // +ve base case
  if (k == 0) {
    System.out.println(node.data);
    return;
  }

  printKLevelsDown(node.left, k - 1);
  printKLevelsDown(node.right, k - 1);
}
