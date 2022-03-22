public static ArrayList<Node> nodeToRootPath(Node node, int data) {
  // -ve base case
  if (node == null) return new ArrayList<>();
  // +ve base case
  if (node.data == data) {
    ArrayList<Node> ans = new ArrayList<>();
    ans.add(node);
    return ans;
  }
  ArrayList<Node> leftAns = nodeToRootPath(node.left, data);
  if (leftAns.size() > 0) {
    leftAns.add(node);
    return leftAns;
  }
  ArrayList<Node> rightAns = nodeToRootPath(node.right, data);
  if (rightAns.size() > 0) {
    rightAns.add(node);
    return rightAns;
  }
  return new ArrayList<>();
}

public static void printKLevelsDown(Node node, int k, Node blockage) {
  // -ve base case
  if (node == null || k < 0 || node == blockage) return;
  // +ve base case
  if (k == 0) {
    System.out.println(node.data);
    return;
  }

  printKLevelsDown(node.left, k - 1, blockage);
  printKLevelsDown(node.right, k - 1, blockage);
}

public static void printKNodesFar(Node node, int data, int k) {
  ArrayList<Node> n2rPath = nodeToRootPath(node, data); // O(n)

  int distance = k;
  for (int i = 0; i < n2rPath.size(); i++) { // O(k)
    if (distance < 0) break;
    Node blockage = (i == 0) ? null : n2rPath.get(i - 1);
    printKLevelsDown(n2rPath.get(i), distance, blockage); // O(n)
    distance--;
  }

  // O(n + k * n) = O(n * k)
}
