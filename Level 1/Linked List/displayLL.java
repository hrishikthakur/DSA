public void display() {
  if (size == 0) {
    return;
  }
  Node temp = head;
  while (temp != null) {
    System.out.print(temp.data + " ");
    temp = temp.next;
  }
  // using for
  //   for (Node temp = head; temp != null; temp = temp.next) {
  //     System.out.print(temp.data + " ");
  //   }
  System.out.println();
}
