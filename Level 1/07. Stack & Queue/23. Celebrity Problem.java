public static void findCelebrity(int[][] arr) {
    Stack<Integer> stk = new Stack<>();
    // push all potential celebrities (row vaale)
    for (int i = 0; i < arr.length; i++) {
        stk.push(i);
    }

    // Finding 1 potential celebrity
    while (stk.size() > 1) {
        int pC2 = stk.pop();
        int pC1 = stk.pop();
        if (arr[pC1][pC2] == 1) {
            //pC1 knows pC2, pC1 is not a celebrity
            stk.push(pC2);
        } else {
            // pC1 does not know pC2, pC2 is not a celebrity
            stk.push(pC1);
        }
    }

    // Confirmation
    int x = stk.pop(); // the only potential celebrity

    // 1. Row should be 0
    for (int j = 0; j < arr[0].length; j++) {
        if (j == x) continue;
        if (arr[x][j] == 1) {
            System.out.println("None");
            return;
        }
    }

    // 2. Col should be 1
    for (int i = 0; i < arr.length; i++) {
        if (i == x) continue;
        if (arr[i][x] == 0) {
            System.out.println("None");
            return;
        }
    }
    System.out.println(x);
}
