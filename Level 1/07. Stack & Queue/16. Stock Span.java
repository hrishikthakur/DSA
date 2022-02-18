public static int[] solve(int[] arr) {
  int[] stock = new int[arr.length];
  Stack<Integer> stk = new Stack<>();
  for (int i = 0; i < arr.length; i++) {
    while (stk.size() > 0 && arr[stk.peek()] < arr[i]) {
      stk.pop();
    }
    // ab jo stack ka peek hai that is our ngeL, i.e, ngeL  = stk.peek();
    // but stock[i] = i - ngeL
    if (stk.size() == 0) {
      // ngeL = -1
      stock[i] = i + 1;
    } else {
      stock[i] = i - stk.peek();
    }
    stk.push(i); // push current
  }
  return stock;
}
