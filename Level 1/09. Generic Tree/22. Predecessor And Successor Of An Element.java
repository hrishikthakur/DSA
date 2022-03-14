static Node predecessor;
static Node successor;
static int state = -1; // can be initialized in main too
public static void predecessorAndSuccessor(Node node, int data) {

  if (state == -1) {

    if (node.data == data) {
      state++;
    } else {
      // potential predecessor
      predecessor = node;
    }
  } else if (state == 0) {
    successor = node;
    state++; // now state = 1
    return; // to prevent further calls from the "CURRENT NODE"
  }

  for (Node child : node.children) {
    if (state == 1) return; // to prevent any further calls from the "current ROOT"
    predecessorAndSuccessor(child, data);
  }
}
