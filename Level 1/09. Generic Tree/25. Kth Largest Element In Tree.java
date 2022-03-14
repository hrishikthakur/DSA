static int floor = Integer.MIN_VALUE;
public static void floor(Node node, int data) {

  if (node.data < data) {
    if (node.data > floor) {
      floor = node.data;
    }
  }

  for (Node child : node.children) {
    floor(child, data);
  }
}

public static int kthLargest(Node node, int k) {
  int ans = Integer.MAX_VALUE;
  for (int i = 1; i <= k; i++) {
    floor = Integer.MIN_VALUE;
    floor(node, ans);
    ans = floor;
  }
  return ans;
}
