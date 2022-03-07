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

// Method 2 -> (Sumeet Sir)connect parent node to the child while returning
// first nodes are created and then the links are connected when -1 is hit
public static node construct(int[] arr) {
    Node root = null;

    Stack<Node> stk = new Stack<>();
    for (int i = 0; i < arr.length; i++) {

        if (arr[i] == -1) {
            Node leaf = stk.pop();
            if (stk.size() == 0) {
                // current node is the root node
                root = leaf;
            } else stk.peek().children.add(leaf); // else the peek element is the parent of the leaf
        }

        else {
            Node newNode = new Node(arr[i]);
            stk.push(newNode);
        }
    }
}
