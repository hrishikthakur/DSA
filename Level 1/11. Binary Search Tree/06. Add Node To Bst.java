// Archit Sirs' Code
public static Node add(Node node, int data) {
  if (node == null) {
    Node newNode = new Node(data, null, null);
    return newNode;
  }

  // if node is already present
  // return without doing any work
  if (data == node.data) return node;
  else if (data < node.data) {
    node.left = add(node.left, data);
  } else {
    node.right = add(node.right, data);
  }

  return node;
}
