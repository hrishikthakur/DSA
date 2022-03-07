public static Node construct(int[] arr) {
    Node root; // here root == null

    Stack<Node> stk = new Stack<>();
    for (int i = 0; i < arr.length; i++) {
        if (arr[i] != -1) {
            // Create a new node
            Node newNode;
            newNode.data = arr[i];

            if (stk.size != 0) {
                // make newNode as the child of the parent node
                stk.peek().children.add(newNode);
            } else {
                // make new node as root node
                root = newNode;
            }

            // 3. while in PREORDER -> push the newNode into the stack
            stk.push(child);
        } else {
            // POSTORDER
            stk.pop();// there is always atleast 1 node hence no need to check if the stack is empty
        }
    }
    return root;
}
