public void removeLast() {
  if (size == 0) {
    System.out.println("List is empty");
    return;
  }
  if (size == 1) {
    head = tail = null;
  } else {
    Node temp = head;
    for (int i = 0; i < size - 2; i++) {
      temp = temp.next;
    }
    temp.next = null;
    tail = temp;
  }
  size--;
}
