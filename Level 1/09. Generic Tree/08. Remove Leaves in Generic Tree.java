// // Incorrect Approach -> Delete Leaf Node in Postorder
// public static void removeLeaves(Node node) {
//     for (Node child : node.children)
//         removeLeaves(child);

//     // reverse loop for "efficent removal" of leaf children
//     // node par khadhe hokar, node.children se pooch rahe hai ki tumhara koi child toh nhi hai (tum leaf ho) ?
//     for (int i = node.children.size() - 1; i >= 0; i--) {
//         Node child = node.children.get(i);
//         if (child.children.size() == 0) {
//             // leaf node
//             node.children.remove(i);
//         }
//     }
// }

// Correct Approach -> Delete Leaf Node in Preorder
public static void removeLeaves(Node node) {
    // reverse loop for "efficent removal" of leaf children
    // node par khadhe hokar, node.children se pooch rahe hai ki tumhara koi child toh nhi hai (tum leaf ho) ?
    for (int i = node.children.size() - 1; i >= 0; i--) {
        Node child = node.children.get(i);
        if (child.children.size() == 0) {
            // leaf node
            node.children.remove(i);
        }
    }

    for (Node child : node.children)
        removeLeaves(child);
}
