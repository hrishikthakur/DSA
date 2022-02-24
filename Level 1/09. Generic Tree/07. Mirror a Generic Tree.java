// Method 1 -> Reverse Using Collection Framework
public static void mirror(Node node) {
  if (node == null) return;
  Collections.reverse(node.children);
  for (Node child : node.children) {
    mirror(child);
  }
}

// Method 2 -> Create Reverse function to reverse ArrayList

// 2.1 Passing Children ArrayList
public static void reverse(ArrayList<Node> arr) {
  int i = 0;
  int j = arr.size() - 1;
  while (i < j) {
    Node leftData = arr.get(i);
    Node rightData = arr.get(j);
    arr.set(i, rightData);
    arr.set(j, leftData);
    j--;
    i++;
  }
}

public static void mirror(Node node) {
  if (node == null) return;
  reverse(node.children);
  for (Node child : node.children) {
    mirror(child);
  }
}

// 2.2 Passing the parent itself
public static void reverse(Node node) {
  int i = 0;
  int j = node.children.size() - 1;
  while (i < j) {
    Node left = node.children.get(i);
    Node right = node.children.get(j);
    node.children.set(i, right);
    node.children.set(j, left);
    i++;
    j--;
  }
}

public static void mirror(Node node) {
  if (node == null) return;
  reverse(node);
  for (Node child : node.children) {
    mirror(child);
  }
}
