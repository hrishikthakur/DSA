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

public static int distanceBetweenNodes(Node node, int d1, int d2) {
  ArrayList<Integer> p1 = nodeToRootPath(node, d1);
  ArrayList<Integer> p2 = nodeToRootPath(node, d2);
  // LCA will be the common point among the two paths

  int i = p1.size() - 1; int j = p2.size() - 1;
  while (i >= 0 && j >= 0 && p1.get(i) == p2.get(j)) {
    i--;
    j--;
  }
  return (i + 1) + (j + 1);
}
