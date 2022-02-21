public static int size(Node node) {
  int count = 1;
  for (Node child : node.children) {
    count += size(child);
  }
  return count;
}
