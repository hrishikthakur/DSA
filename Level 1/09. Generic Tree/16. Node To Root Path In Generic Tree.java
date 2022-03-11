public static ArrayList<Integer> nodeToRootPath(Node node, int data) {

  if (node.data == data) {
    // +ve Base Case : Element Found
    // Create new ArrayList, add data to it and return
    ArrayList<Integer> ans = new ArrayList<>();
    ans.add(data);
    return ans;
  }

  for (Node child : node.children) {
    ArrayList<Integer> temp = nodeToRootPath(child, data);

    if (temp.size() > 0) {
      // +ve base case was hit and temp has the target in it
      // now add current node ka data and return;
      temp.add(node.data);
      return temp;
    }
  }

  return new ArrayList<>();
}
