public static class QueueToStackAdapter {
  Queue<Integer> q;

  public QueueToStackAdapter() {
    q = new ArrayDeque<>();
  }

  int size() {
    return q.size();
  }

  void push(int val) {
    q.add(val);
  }

  int pop() {
    if (size() == 0) {
      System.out.println("Stack underflow");
      return -1;
    }
    int val = 0;
    int initialSize = size();
    for (int i = 0; i < size(); i++) {
      // (1) for this entire loop size() is constant ,i.e, size() == initialSize
      // (2) q.remove() -> size-- && q.add(val) -> size++;
      val = q.remove();
      // (3) here size() = size() - 1
      if (i < initialSize - 1) {
        q.add(val);
      }
    }
    return val;
  }

  int top() {
    if (size() == 0) {
      System.out.println("Stack underflow");
      return -1;
    }
    int val = 0;
    for (int i = 0; i < size(); i++) {
      val = q.remove();
      q.add(val);
    }
    return val;
  }
}
