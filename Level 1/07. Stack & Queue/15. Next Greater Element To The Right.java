// APPROACH - 1.1 (L -> R)
public static int[] solve(int[] arr) {

    int[] nge = new int[arr.length];
    // initialize all values of nge[] with -1
    Arrays.fill(nge, -1);

    Stack<Integer> stk = new Stack<Integer>();
    for (int i = 0; i < arr.length; i++) {
        // when to pop ?
        // jab takk current element is greater than that at arr[stk.peek()]
        while (stk.size() > 0 && arr[stk.peek()] < arr[i]) {
            // stack me indices are being pushed, hence arr[stk.peek()]
            nge[stk.peek()] = arr[i];   // current par khadhe hokar pichle sabhi ka kaam
            stk.pop();
        }
        stk.push(i);    // push the current index too, kyunki humme apna bhi ans dhoondhna hai
    }
    return nge;
}

// APPROACH - 1.2 (L -> R)
public static int[] solve(int[] arr) {

    int[] nge = new int[arr.length];

    Stack<Integer> stk = new Stack<Integer>();
    for (int i = 0; i < arr.length; i++) {
        while (stk.size() > 0 && arr[stk.peek()] < arr[i]) {
            nge[stk.peek()] = arr[i];
            stk.pop();
        }
        stk.push(i);
    }

    // initialize nge[of all indices left in the stack as they have no ngeR] = -1;
    while (stk.size() > 0) {
        nge[stk.peek()] = -1;
        stk.pop();
    }

    return nge;
}

// APPROACH - 2 (R -> L)
public static int[] solve(int[] arr) {
    int[] nge = new int[arr.length];
    Arrays.fill(nge, -1);
    Stack<Integer> stk = new Stack<>();
    for (int i = arr.length - 1; i >= 0; i--) {
        // when to pop
        // jab tak current element is '>=' arr[stk.peek()] we can be the ans(nge)
        while (stk.size() > 0 && arr[i] >= arr[stk.peek()])
            stk.pop();

        if (stk.size() > 0)
            nge[i] = arr[stk.peek()];   // current par khadhe hokar current ka kaam

        // push current because we might be the nge of some one
        stk.push(i);
    }
    return nge;
}
