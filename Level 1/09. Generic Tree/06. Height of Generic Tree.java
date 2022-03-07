// Method 1 -> In terms of nodes
public static int heightbyNodes(Node root) {
    int height = 0;
    for (Node child : root.children)
        height = Math.max(height, heightbyNodes(child));
    return height + 1;
}
public static int height(Node root) {
    if (root == null) return;
    int ans = heightbyNodes(root);
    // because, number of edges = (number of nodes) - 1
    return ans - 1;
}

// Method 2 -> In terms of edges
// leaf returns 0, but the parent of leaf receives (0 + 1) for the edge involved
public static int height(Node root) {
    int height = 0;
    for (Node child : root.children)
        height = Math.max(height, height(child) + 1);
    return height;
}

// Method 3 -> In terms of edges
public int height(Node root) {
    if (root == null) return 0;
    int height = -1;
    for (Node child : root.children) {
        height = Math.max(height, height(child));
    }
    return height + 1;
}
