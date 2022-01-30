public static class TwoStack {
  int[] data;
  int tos1;
  int tos2;

  public TwoStack(int cap) {
    // write your code here
    data = new int[cap];
    tos1 = -1;
    tos2 = data.length;
  }

  int size1() {
    // write your code here
    return tos1 + 1;
  }

  int size2() {
    // write your code here
    return (data.length - 1) - tos2;
  }

  void push1(int val) {
    // write your code here
    if (tos1 + 1 == tos2) {
      System.out.println("Stack overflow");
      return;
    }
    tos1++;
    data[tos1] = val;
  }

  void push2(int val) {
    // write your code here
    if (tos2 - 1 == tos1) {
      System.out.println("Stack overflow");
      return;
    }
    tos2--;
    data[tos2] = val;
  }

  int pop1() {
    // write your code here
    if (tos1 == -1) {
      System.out.println("Stack underflow");
      return -1;
    }
    tos1--;
    return data[tos1 + 1];
  }

  int pop2() {
    // write your code here
    if (tos2 == data.length) {
      System.out.println("Stack underflow");
      return -1;
    }
    tos2++;
    return data[tos2 - 1];
  }

  int top1() {
    // write your code here
    if (tos1 == -1) {
      System.out.println("Stack underflow");
      return -1;
    }
    return data[tos1];
  }

  int top2() {
    // write your code here
    if (tos2 == data.length) {
      System.out.println("Stack underflow");
      return -1;
    }
    return data[tos2];
  }
}
