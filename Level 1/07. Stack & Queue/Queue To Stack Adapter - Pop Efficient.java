public static class QueueToStackAdapter {
  Queue<Integer> mainQ;
  Queue<Integer> helperQ;

  public QueueToStackAdapter() {
    mainQ = new ArrayDeque<>();
    helperQ = new ArrayDeque<>();
  }

  int size() {
    return mainQ.size();
  }

  void push(int val) {
    while (mainQ.size() > 0)
      helperQ.add(mainQ.remove());

    mainQ.add(val);

    while (helperQ.size() > 0)
      mainQ.add(helperQ.remove());
  }

  int pop() {
    if (size() == 0) {
      System.out.println("Stack underflow");
      return -1;
    }
    int val = mainQ.remove();
    return val;
  }

  int top() {
    if (size() == 0) {
      System.out.println("Stack underflow");
      return -1;
    }
    return mainQ.peek();
  }
}
