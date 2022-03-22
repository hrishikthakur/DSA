// Method 1 -> Using String path
// No need to backtrack the changes made in a string
// Because everytime path is concatenated a new string is created
public static void pathToLeafFromRoot(Node node, String path, int sum, int lo, int hi) {
  if (node == null) return;

  sum += node.data;
  path = path + node.data + " ";

  if (node.left == null && node.right == null) {
    // leaf node
    if (sum >= lo && sum <= hi) System.out.println(path);
    return;
  }

  pathToLeafFromRoot(node.left, path, sum, lo, hi);
  pathToLeafFromRoot(node.right, path, sum, lo, hi);
}

// Method 2 -> Using StringBuilder
public static void pathToLeafFromRoot(Node node, StringBuilder path, int sum, int lo, int hi) {
  if (node == null) return;

  sum += node.data;
  path.append(node.data);
  path.append(" ");

  if (node.left == null && node.right == null) {
    // leaf node
    if (sum >= lo && sum <= hi)
      System.out.println(path);

    path.deleteCharAt(path.length() - 1);
    for (int i = path.length() - 1; i >= 0 && path.charAt(i) != ' '; i--) {
      path.deleteCharAt(i);
    }
    return;
  }

  pathToLeafFromRoot(node.left, path, sum, lo, hi);
  pathToLeafFromRoot(node.right, path, sum, lo, hi);

  path.deleteCharAt(path.length() - 1);
  for (int i = path.length() - 1; i >= 0 && path.charAt(i) != ' '; i--) {
    path.deleteCharAt(i);
  }
}
