// Method 1 -> Using 2 Queues and 2 while loops (Archit sir)
public static void levelOrderLinewise(Node node) {
  Queue<Node> mainq = new ArrayDeque<>();
  mainq.add(node);

  while (mainq.size() > 0) {
    Queue<Node> childq = new ArrayDeque<>();

    while (mainq.size() > 0) {
      // remove
      Node poped = mainq.remove();
      // print
      System.out.print(poped.data + " ");
      // add children
      for (Node child : poped.children)
        childq.add(child);
    }
    System.out.println();
    mainq = childq;
  }
}

// Method 2 -> Using single Queue, single while loop and a "delimeter" ,i.e, -1
// Delimeter marks the end of one level
public static void levelOrderLinewise(Node node) {
  if (node == null) return;

  Queue<Node> q = new Queue<>();
  Node dummy = new node(-1);

  q.add(node);
  q.add(dummy);

  while (q.size() > 0) {
    // 1. remove
    Node poped = q.remove();

    if (poped.data != -1) {
      // 2. print
      System.out.print(poped.data + " ");
      // 3. add all children of the poped node
      for (node child : poped.children)
        q.add(child);
    } else {
      // if poped.data == -1 ek delimeter gya ab doosra aega
      System.out.println();
      if (q.size() > 0) {
        // add delimeter only when it is not the last node of the tree
        // -1 hit hua -> isse pehle sabhi child push ho chuke honge queue me
        // incase queue me -1 k baad koi element hai hi nhi, it implies that it was the last node of the tree
        q.add(dummy);
      }
    }

  }
}

// Method 3 -> Using a counter to know level change
public static void levelOrderLinewise(Node node) {
  Queue<Node> q = new ArrayDeque<>();
  q.add(node);

  while (q.size() > 0) {
    int counter = q.size();
    // within this while loop "q.size()" varies
    // hence a counter variable was required
    while (counter-- > 0) {
      // remove
      Node poped = q.remove();
      // print
      System.out.print(poped.data + " ");
      // add children of poped into the queue
      for (Node child : poped.children)
        q.add(child);
    }
    System.out.println();
  }
}

