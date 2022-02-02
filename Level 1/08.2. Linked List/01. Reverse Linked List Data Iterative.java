public void removeAt(int idx) {
  if (idx < 0 || idx >= size) {
    System.out.println("Invalid arguments");
  } else if (idx == 0) {
    removeFirst();
  } else if (idx == size - 1) {
    removeLast();
  } else {
    Node temp = head;
    for (int i = 0; i < idx - 1; i++) {
      temp = temp.next;
    }

    temp.next = temp.next.next;
    size--;
  }
}

public Node getNodeAt(int idx) {
  Node temp = head;
  for (int i = 0; i < idx; i++) {
    temp = temp.next;
  }
  return temp;
}

public void swap(Node leftNode, Node rightNode) {
  int leftData = leftNode.data;
  leftNode.data = rightNode.data;
  rightNode.data = leftData;
}

public void reverseDI() {
  int left = 0;
  int right = size - 1;
  while (left < right) {
    Node leftNode = getNodeAt(left);
    Node rightNode = getNodeAt(right);
    swap(leftNode, rightNode);
    left++;
    right--;
  }
}
