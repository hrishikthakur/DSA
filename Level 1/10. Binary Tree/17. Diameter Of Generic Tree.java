static int maxDia = 0;
public static int diameter(Node node) {

  int max1 = -1 , max2 = -1;
  for (Node child : node.children) {
    int hc = diameter(child); // height of child

    // find maximum height & 2nd maximum height
    if (hc >= max1) {
      max2 = max1;
      max1 = hc;

    } else if (hc >= max2) {
      max2 = hc;
    }
  }

  int currDia = max1 + max2 + 2;
  maxDia = Math.max(currDia, maxDia);

  return max1 + 1; // height + 1
}
