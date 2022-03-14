// Method 1 -> Using "static variables"
// NOT PREFFERED, because static varibles are in memory for as long as the program is running
static int size = 0;
static int min = Integer.MAX_VALUE;
static int max = Integer.MIN_VALUE;
static int height = 0;

public static void multisolver(Node root, int level) {
  if (root == null) return;

  // Preorder
  size++;
  if (root.data > max) max = root.data;
  if (root.data < min) min = root.data;
  if (level > height) height = level;

  for (Node child : node.children)
    multisolver(child, level + 1);
}

// Method 2 -> Returning a Multisolver class
public static class Multisolver {
  int size;
  int min;
  int max;
  int height = 0;

  Multisolver(int size, int min, int max) {
    this.size = size;
    this.min = min;
    this.max = max;
  }
}

public static Multisolver multisolver(Node root) {
  Multisolver ans = new Multisolver(1, root.data, root.data);

  for (Node child : root.children) {
    Multisolver temp = multisolver(child);
    ans.size += temp.size;
    ans.min = Math.min(ans.min, temp.min);
    ans.max = Math.max(ans.max, temp.max);
    ans.height = Math.max(ans.height, temp.height + 1);
  }
  return ans;
}

// Method 3 -> Passing an array as a parameter to store the values
// Because array is created in the heap, changes made in heap always persist
public static void multisolver(Node root, int level, int[] ans) {
  ans[0]++;
  if (root.data < ans[1]) min = root.data;
  if (root.data > ans[2]) max = root.data;
  if (level > ans[3]) ans[3] = level;

  for (Node child : root.children)
    mujltisolver(child, level + 1, ans); s
}
