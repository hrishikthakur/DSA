void addLast(int val) {

  // create a new node
  Node temp = new Node();
  temp.data = val;

  if (size == 0) {
    head = temp;
    tail = temp;
  } else {
    tail.next = temp;
    tail = temp;
  }
  size++;
}
