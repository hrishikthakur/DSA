public static class TwoStack {
  int[] data;
  int tos1;
  int tos2;

  public TwoStack(int cap) {
    data = new int[cap];
    tos1 = -1;
    tos2 = data.length;
  }

  int size1() {
    return tos1 + 1;
  }

  int size2() {
    return data.length - tos2;
  }

  void push1(int val) {
    if (tos1 + 1 == tos2) {
      System.out.println("Stack overflow");
      return;
    }
    tos1++;
    data[tos1] = val;
  }

  void push2(int val) {
    if (tos2 - 1 == tos1) {
      System.out.println("Stack overflow");
      return;
    }
    tos2--;
    data[tos2] = val;
  }

  int pop1() {
    if (tos1 == -1) {
      System.out.println("Stack underflow");
      return -1;
    }
    tos1--;
    return data[tos1 + 1];
  }

  int pop2() {
    if (tos2 == data.length) {
      System.out.println("Stack underflow");
      return -1;
    }
    tos2++;
    return data[tos2 - 1];
  }

  int top1() {
    if (tos1 == -1) {
      System.out.println("Stack underflow");
      return -1;
    }
    return data[tos1];
  }

  int top2() {
    if (tos2 == data.length) {
      System.out.println("Stack underflow");
      return -1;
    }
    return data[tos2];
  }
}
