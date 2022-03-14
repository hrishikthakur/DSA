// Method 1 -> Using Global Variables
static int maxSum = Integer.MIN_VALUE;
static Node maxSumNode = null;

public static int subtreeSum(Node root) {

  // aisa koi subtree nhi hoga jisme root na aaye
  int sum = root.data;
  for (Node child : root.children)
    sum += subtreeSum(child);

  if (sum > maxSum) {
    maxSum = sum;
    maxSumNode = root;
  }
  // Note that we are returning the current subtree ka sum
  return sum;
}

// Method 2 -> Returning a Pair Class
public static class Pair {
  int sum;
  int maxSum;
  Node maxSumNode;

  Pair(int sum) {
    this.sum = sum;
  }
}

public static Pair subtreeSum(Node root) {
  Pair ans = new Pair(root.data);

  for (Node child : root.children) {
    Pair temp = subtreeSum(child);

    // Postorder ... kiska ?? Child ka
    ans.sum += temp.sum;

    if (temp.maxSum > ans.maxSum) {
      ans.maxSum = temp.maxSum;
      ans.maxSumNode = temp.maxSumNode;
    }
  }

  // Postorder of the parent
  if (ans.sum > ans.maxSum) {
    ans.maxSum = ans.sum;
    ans.maxSumNode = root;
  }
  return ans;
}
