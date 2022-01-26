public void addAt(int idx, int val) {
  if (idx < 0 || idx > size) { // notice that size - 1 is a valid index
    System.out.println("Invalid arguments");
    return;
  }

  Node newNode = new Node();
  newNode.data = val;

  if (size == 0) {
    head = newNode;
    tail = newNode;
  } else if (idx == size) {
    tail.next = newNode;
    tail = newNode;
  } else if (idx == 0) {
    newNode.next = head;
    head = newNode;
  } else {
    Node temp = head;
    for (int i = 0; i < idx - 1; i++) {
      temp = temp.next;
    }
    newNode.next = temp.next;
    temp.next = newNode; // I made temp.next = newNode;
  }
  size++;
}
