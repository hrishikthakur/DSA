public static void display(Node node) {

    // Base Case -> Not required
    if (node == null) return;

    // PREORDER -> Meeting expectation
    System.out.print(node.data + " -> ");
    for (Node child : node.children) {
        System.out.print(child.data + ", ");
    }
    System.out.println(".");

    for (Node child : node.children) {
        display(child);
    }
}
