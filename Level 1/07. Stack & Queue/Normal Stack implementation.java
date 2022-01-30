public static class CustomStack {
  int[] data;
  int top;

  public CustomStack(int cap) {
    data = new int[cap];
    top = -1;
  }

  int size() {
    return top + 1;
  }

  void display() {
    for (int i = top; i >= 0; i--) {
      System.out.print(data[i] + " ");
    }
    System.out.println();
  }

  void push(int val) {
    if (top == data.length - 1) {
      // Stack Overflow
      System.out.println("Stack overflow");
      return;
    }
    top++; // note top pehle increment krna hai
    data[top] = val;
  }

  int pop() {
    if (top == -1) {
      // Stack underflow
      System.out.println("Stack underflow");
      return -1;
    }
    int val = data[top];
    top--;
    return val;
  }

  int top() {
    if (top == -1) {
      // Stack underflow
      System.out.println("Stack underflow");
      return -1;
    }
    int val = data[top];
    return val;
  }
}
