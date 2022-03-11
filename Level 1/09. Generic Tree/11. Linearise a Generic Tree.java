// Method 1 -> O(N * N)
public static Node getTail(Node subTreeRoot) {
  // Remember : the tree is linearised
  while (subTreeRoot.children.size() > 0)
    subTreeRoot = subTreeRoot.children.get(0);
  //return leaf/tail
  return subTreeRoot;
}

public static void linearize(Node node) {
  if (node == null) return;

  // faith
  for (Node child : node.children)
    linearize(child);

  // root node par kadhe hokar dekho
  // (left -> right) travel karte hue link thodhne hai ... kab takk ???
  // jab takk root.children.size() > 1
  // because only the 1st link remains with the root after linearisation
  while (node.children.size() > 1) {
    Node lastTreeRoot = node.children.remove(node.children.size() - 1);
    // NOTICE - here again "size - 1" because already ek child remove kar chukke hai
    Node secondLastTreeTail = getTail(node.children.get(node.children.size() - 1));
    secondLastTreeTail.children.add(lastTreeRoot);
  }
}

// Method 2 -> O(N)
public static Node linearizeOpt(Node node) {
  if (node.children.size() == 0) return node;

  Node lastTreeTail = linearizeOpt(node.children.get(node.children.size() - 1));

  while (node.children.size() > 1) {
    Node lastTreeHead = node.children.remove(node.children.size() - 1);
    Node secondLastTreeTail = linearizeOpt(node.children.get(node.children.size() - 1));
    secondLastTreeTail.children.add(lastTreeHead);
  }

  return lastTreeTail;
}
