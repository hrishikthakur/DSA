static int ceil = Integer.MAX_VALUE;
static int floor = Integer.MIN_VALUE;
public static void ceilAndFloor(Node node, int data) {

  if (node.data > data) {
    // find badho me sabse chota
    ceil = Math.min(ceil, node.data);
  } else if (node.data < data) {
    // find choto me sabse badha
    floor = Math.max(floor, node.data);
  }

  for (Node child : node.children)
    ceilAndFloor(child, data);

}
