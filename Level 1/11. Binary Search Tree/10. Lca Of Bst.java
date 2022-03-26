public static int lca(Node node, int d1, int d2) {

  // base case
  if (node.data == d1 || node.data == d2) {
    return node.data;

  } else if (d1 < node.data && d2 < node.data) {
    return lca(node.left, d1, d2);

  } else if (d1 > node.data && d2 > node.data) {
    return lca(node.right, d1, d2);

  } else {
    // d1 < node.data < d2
    // (OR) d2 < node.data < d1
    return node.data;

  }
}

// This code will fail if one node does not exist
// if(find(d1) && find(d2)) call lca;
// else return null;
