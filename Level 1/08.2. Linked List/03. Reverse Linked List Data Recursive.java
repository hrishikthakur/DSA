// Method -> 1 -> Incorrect approach
// Modifying the local parameter right = right.next;
// Changes will be gone once the stack is popped off

// Method -> 2
// Return the left pointer to save the changes made in one recursion stack
// (return type "Node" required)
public void swap(Node leftNode, Node rightNode) {
  int nodeData = leftNode.data;
  leftNode.data = rightNode.data;
  rightNode.data = nodeData;
}

public Node reverseDR(Node left, Node right, int counter) {
  if (left == null) {
    return right;
  }
  right = reverseDR(left.next, right, counter + 1);
  if (counter < size / 2) {
    swap(left, right);
  }
  right = right.next;
  return right;
}

public void reverseDR() {
  Node left = head;
  Node right = head;
  reverseDR(left, right, 0);
}

// Method -> 3
// Using a static/global variable (No return type required)

public void swap(Node leftNode, Node rightNode) {
  int nodeData = leftNode.data;
  leftNode.data = rightNode.data;
  rightNode.data = nodeData;
}

static Node right;
public void reverseDR(Node left, int counter) {
  if (left == null) {
    return;
  }
  reverseDR(left.next, right, counter + 1);
  if (counter < size / 2) {
    swap(left, right);
  }
  right = right.next;
}

public void reverseDR() {
  right = head;
  Node left = head;
  reverseDR(right, 0);
}
