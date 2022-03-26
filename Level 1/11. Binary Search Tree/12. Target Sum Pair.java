// Approach 1 -> O(n * h)
public static void approach1(Node node, int target, Node root) {
  // here root is passed so that we can find compliment in the entire tree
  if (node == null) return;

  approach1(node.left, target, root);

  // To avoid repetitive pairs (reflection pairs)
  // For target = 20 ... 10,10 bhi print nhi karna, hence '=' in required
  if (node.data >= target / 2) return;

  int compliment = target - node.data;
  if (find(root, compliment)) {
    System.out.println(node.data + " " + compliment);
  }

  approach1(node.right, target, root);
}

// Approach 2 -> O(n)
public static void approach2(Node node, int target) {

  ArrayList<Integer> inorder = new ArrayList<>(); // O(N)  Space
  inorder(node, inorder); // O(N) -> Insert elements to the ArrayList in sorted order

  // O(N) -> Two pointer on ArrayList
  int left = 0, right = inorder.size() - 1;

  while (left < right) {
    int sum = inorder.get(left) + inorder.get(right);
    if (sum == target) {
      System.out.println(inorder.get(left) + " " + inorder.get(right));
      left++; right--;

    } else if (sum < target) {
      left++;

    } else {
      right--;
    }
  }
}

// Approach 3
// O(n) time, O(h) stack space
public static void approach3(Node root, int target) {
  Stack<Pair> inorder = new Stack<>();
  inorder.push(new Pair(root, -1));

  Stack<Pair> reverseInorder = new Stack<>();
  reverseInorder.push(new Pair(root, -1));

  int left = iterativeInorder(inorder);
  int right = iterativeReverseInorder(reverseInorder);

  while (left < right) {

    if (left + right == target) {
      System.out.println(left + " " + right);
      left = iterativeInorder(inorder);
      right = iterativeReverseInorder(reverseInorder);

    } else if (left + right < target) {
      left = iterativeInorder(inorder);
    } else {
      right = iterativeReverseInorder(reverseInorder);
    }
  }
}

public static int iterativeInorder(Stack<Pair> stk) {
  while (!stk.isEmpty()) {
    Pair par = stk.peek();

    if (par.state == -1) {
      // preorder

      if (par.node.left != null) {
        stk.push(new Pair(par.node.left, -1));
      }
      par.state++;

    } else if (par.state == 0) {
      // inorder
      int val = par.node.data;

      // before returning, setup the next element into the stack
      // Setup -> push the next element then increase the state of current
      if (par.node.right != null) {
        stk.push(new Pair(par.node.right, -1));
      }
      par.state++;

      // Now return
      return val;

    } else if (par.state == 1) {
      // postorder
      stk.pop();
    }
  }

  return -1;
}

public static int iterativeReverseInorder(Stack<Pair> stk) {

  while (!stk.isEmpty()) {
    Pair par = stk.peek();

    if (par.state == -1) {
      // reverse preorder
      if (par.node.right != null) {
        stk.push(new Pair(par.node.right, -1));
      }
      par.state++;

    } else if (par.state == 0) {
      // reverse inorder
      int val = par.node.data;

      if (par.node.left != null) {
        stk.push(new Pair(par.node.left, -1));
      }
      par.state++;

      return val;

    } else if (par.state == 1) {
      // reverse postorder
      stk.pop();
    }
  }

  return -1;
}
