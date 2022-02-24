// Method 1 -> O(n * n)
// -> Getting Tail Node everytime tailNode is to be connected to the uppermost  right child
public static Node getTail(Node node) {
    while (node.children.size() > 0) {
        node = node.children.get(0);
    }
    return node;
}

public static void linearize(Node node) {
    if (node == null) return;

    for (Node child : node.children)
        linearize(child);

    // POSTORDER -> Mera Kaam
    // Notice "i > 0", this is because 1st vale child se link nhi todhna
    for (int i = node.children.size() - 1; i > 0; i--) {
        Node rightChidTop = node.children.get(i); // the top most right child
        Node leftChildTail = getTail(node.children.get(i - 1));
        leftChildTail.children.add(rightChidTop);
        node.children.remove(i); // bas remove efficiently ho jae isliye reverse loop lagai hai
    }
}

// Method 2 -> O(n)
