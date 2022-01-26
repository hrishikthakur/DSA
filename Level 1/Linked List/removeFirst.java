public void removeFirst() {
  if (size == 0) {
    System.out.println("List is empty");
    return;
  }
  if (size > 1) {
    head = head.next;
  } else {
    head = null;
    tail = null;
  }
  size--;
}
