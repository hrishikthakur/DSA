// Method 1 -> Using Extra Space

public static class MinStack {
  Stack<Integer> allData;
  Stack<Integer> minData;

  public MinStack() {
    allData = new Stack<>();
    minData = new Stack<>();
    minData.push(Integer.MAX_VALUE);
  }

  int size() {
    return allData.size();
  }

  void push(int val) {
    allData.push(val);
    if (minData.size() > 0)
      minData.push(Math.min(val, minData.peek()));
    else minData.push(val);
  }

  int pop() {
    if (size() == 0) return -1;
    minData.pop();
    return allData.pop();
  }

  int top() {
    if (size() == 0) return -1;
    return allData.peek();
  }

  int min() {
    if (size() == 0) return -1;
    return minData.peek();
  }
}

// Method 2 -> Without Using Extra Space

