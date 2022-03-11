public static ArrayList<Integer> nodeToRootPath(Node node, int data) {
  if (node.data == data) {
    ArrayList<Integer> path = new ArrayList<>();
    path.add(node.data);
    return path;
  }

  for (Node child : node.children) {
    ArrayList<Integer> ptc = nodeToRootPath(child, data);
    if (ptc.size() > 0) {
      ptc.add(node.data);
      return ptc;
    }
  }

  return new ArrayList<>();
}

// Given -> d1 & d2 both will exist and both will be unique.
public static int lca(Node node, int d1, int d2) {
  // get "node To Root Path"
  ArrayList<Integer> a1 = nodeToRootPath(node, d1);
  ArrayList<Integer> a2 = nodeToRootPath(node, d2);

  int LCA = -1;
  int i = a1.size() - 1, j = a2.size() - 1;
  // iterate ArrayList in reverse order, i.e, iterating the tree in top to bottom fashion
  // hence last common Node will be the LCA
  while (i >= 0 && j >= 0) {

    // the last element for a1 & a2 will always be same
    // because a1.get(a1.size() - 1) == a2.get(a2.size() - 1) == root node
    // Why ? for the if -> Think in terms of tree not in terms of the ArrayList
    if (a1.get(i) != a2.get(j))
      break;

    // else
    LCA = a1.get(i);
    i--; j--;
  }
  return LCA;
}
