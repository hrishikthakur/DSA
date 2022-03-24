// NOTE -> While calculating diameter what we are really calculating is the "height"
// From height we calculate the diameter nd return it

// Method 1 ->
// O(n * n) because of height
// leftHeight aur rightHeight mangvaya ... usse diameter banaya ... nd return diameter
public static int diameter1(Node node) {
    if (node == null) return 0;

    int lDia = diameter1(node.left);
    int rDia = diameter1(node.right);

    // Meeting Expectation
    int lh = height(node.left);
    int rh = height(node.right);
    int dia = lh + rh + 2;

    return Math.max(dia, Math.max(lDia, rDia));
}

// Method 2 -> Using static int maxDiameter
// Return -> Height
// Calculate -> Diameter

// 2.1
// Height is excluding the edge connecting leftChild nd the edge connecting rightChild to root
// int dia = lh + rh + 2;
static int maxDiameter = 0;
public static int diameter2(Node node) {
    if (node == null) return -1;

    int lh = diameter2(node.left);
    int rh = diameter2(node.right);

    // 2 here is the edges connecting root to leftChild node nd rightChild node
    int dia = lh + rh + 2;
    maxDiameter = Math.max(maxDiameter, dia);

    return Math.max(lh, rh) + 1;
}

// 2.2
// Height is including both the edges connecting root to leftChild nd the rightChild
// Hence no need to add 2 to the diameter
// int dia = lh + rh;
static int maxDiameter = 0;
public static int diameter2(Node node) {
    if (node == null) return 0;

    int lh = 0;
    int rh = 0;
    // checking if(node.left != null) and if(node.right != null) is V.V.V necessary
    // 1 here is edge connecting root node to the left child nd the right child
    if (node.left != null) lh = 1 + diameter2(node.left);
    if (node.right != null) rh = 1 + diameter2(node.right);

    int dia = lh + rh;
    maxDiameter = Math.max(maxDiameter, dia);

    return Math.max(lh, rh);
}

// Method 3 -> Return both Height & Diameter

public static class diaPair {
    int height;
    int diameter;

    public diaPair() {
        height = -1;
        diameter = 0;
    }
}

public static diaPair diameter3(Node node) {
    if (node == null) return new diaPair();

    diaPair l = diameter3(node.left);
    diaPair r = diameter3(node.right);

    diaPair res = new diaPair();
    res.height = Math.max(l.height, r.height) + 1;

    int dia = l.height + r.height + 2;
    res.diameter = Math.max(dia, Math.max(l.diameter, r.diameter));

    return res;
}
