public void reversePI() {
  if (head == null || head.next == null) {
    // if size ==0 || size == 1 no need to reverse the list
    return;
  }

  Node prev = null;
  Node curr = head;

  while (curr != null) {
    Node ahead = curr.next;
    curr.next = prev;
    prev = curr;
    curr = ahead;
  }

  //swap(head,tail);  this won't work work ??? -> sir ka chal gya tha
  Node temp = head;
  head = tail;
  tail = temp;
}
