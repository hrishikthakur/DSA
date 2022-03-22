public static class Node {
  int data;
  Node left;
  Node right;

  Node(int data) {
    this.data = data;
  }
}

public static class Pair {
  Node node;
  int state;

  Pair(Node node, int state) {
    this.node = node;
    this.state = state;
  }
}

// Integer(Wrapper class is used here because null is one of the element in the arr[])
public static Node construct(Integer[] arr) {
  Stack<Pair> stk = new Stack<>();
  Node root = new Node(arr[0]);
  stk.push(new Pair(root, -1));
  int idx = 0;

  while (stk.size() > 0) {

    Pair parent = stk.peek();

    if (parent.state == -1) {
      // Preorder
      idx++;
      if (arr[idx] != null) {
        Node child = new Node(arr[idx]);
        parent.node.left = child;
        stk.push(new Pair(child, -1));
      }
      parent.state++;

    } else if (parent.state == 0) {
      // Inorder -> increment state
      idx++;
      if (arr[idx] != null) {
        Node child = new Node(arr[idx]);
        parent.node.right = child;
        stk.push(new Pair(child, -1));
      }
      parent.state++;

    } else if (parent.state == 1) {
      // Postorder -> pop Pair
      stk.pop();
    }
  }
  return root;
}
