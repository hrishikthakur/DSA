// find
public static boolean find(Node node, int data) {
  if (node == null) return false;
  // return  (node.data == data) ? true : (find(node.left, data)) || (find(node.right, data));

  if (node.data == data) return true;

  boolean leftAns = find(node.left, data);
  if (leftAns == true) return true;

  boolean rightAns = find(node.right, data);
  if (rightAns == true) return true;

  return false;
}

// 1.
// Node to root path
public static ArrayList<Integer> nodeToRootPath(Node node, int data) {
  // -ve base case
  if (node == null) return new ArrayList<>();

  // +ve base case
  if (node.data == data) {
    ArrayList<Integer> ans = new ArrayList<>();
    ans.add(node.data);
    return ans;
  }

  ArrayList<Integer> leftAns = nodeToRootPath(node.left, data);
  if (leftAns.size() > 0) {
    leftAns.add(node.data);
    return leftAns;
  }
  ArrayList<Integer> rightAns = nodeToRootPath(node.right, data);
  if (rightAns.size() > 0) {
    rightAns.add(node.data);
    return rightAns;
  }
  return new ArrayList<>();
}

// 2.
// Root to node path
// All nodes are unique
public static boolean nodeToRootPath2(Node node, int data, ArrayList<Integer> curr) {
  // -ve base case
  if (node == null) return false;

  // +ve base case
  if (node.data == data) {
    curr.add(data);
    return true;
  }

  curr.add(node.data);

  boolean leftAns = nodeToRootPath2(node.left, data, curr);
  if (leftAns == true) return true;

  boolean rightAns = nodeToRootPath2(node.right, data, curr);
  if (rightAns == true) return true;

  curr.remove(curr.size() - 1);
  return false;
}

// 3.
// Root to node path
// A node is present more than once
public static void nodeToRootPath3(Node node, int data, ArrayList<Integer> curr, ArrayList<ArrayList<Integer>> res) {
  // -ve base case
  if (node == null) return;

  curr.add(node.data);

  // +ve base case
  if (node.data == data) {

    // DEEP COPY the ArrayList "curr"
    ArrayList<Integer> temp = new ArrayList<>();
    for (Integer i : curr)
      temp.add(i);

    // add ArrayList "temp" to ArrayList of ArrayList (res)
    res.add(temp);
  }

  nodeToRootPath3(node.left, data, curr, res);
  nodeToRootPath3(node.right, data, curr, res);
  curr.remove(curr.size() - 1);
}
