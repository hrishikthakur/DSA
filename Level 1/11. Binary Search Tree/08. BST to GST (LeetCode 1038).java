// ***************************   LeetCode   ***************************

class Solution {
    static int sum = 0;
    public TreeNode bstToGst(TreeNode root) {
        sum = 0;
        return bstToGstHelper(root);
    }

    public TreeNode bstToGstHelper(TreeNode root) {
        if (root == null) return null;

        // for reverse inorder
        root.right = bstToGstHelper(root.right);
        // inorder
        sum += root.val;
        root.val = sum;
        // now root.left ki call
        root.left = bstToGstHelper(root.left);

        return root;
    }
}

// In LeetCode ->
// All test cases are run in the same program.
// Now for static variable "sum", sum will never be set back to 0 for different test cases
// this is because static variables are properties of class and will remain same everytime new obj of the class is created
// Hence a helper function was needed to set sum = 0 for different test cases

class Solution {
    int sum = 0;
    public TreeNode bstToGst(TreeNode root) {
        sum = 0;
        return bstToGstHelper(root);
    }

    public TreeNode bstToGstHelper(TreeNode root) {
        if (root == null) return null;

        // for reverse inorder
        root.right = bstToGstHelper(root.right);
        // inorder
        sum += root.val;
        root.val = sum;
        // now root.left ki call
        root.left = bstToGstHelper(root.left);

        return root;
    }
}

// Now if we create a non static variable sum
// a helper function will no longer be needed
// as non static members of a class are created again when a new obj of class is created.

// Summary ->
// For every test case new obj is created.
// Static members being static are properties of class and will be same for all objects.
// Non static members are properties of obj and every obj will have sum = 0.
