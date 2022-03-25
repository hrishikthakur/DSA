class Solution {

    public TreeNode sortedArrayToBST(int[] nums, int l, int r) {
        if (l > r) return null;

        int mid = (l + r) / 2;
        TreeNode rootNode = new TreeNode(nums[mid]);

        TreeNode leftNode = sortedArrayToBST(nums, l, mid - 1);
        TreeNode rightNode = sortedArrayToBST(nums, mid + 1, r);

        rootNode.left = leftNode;
        rootNode.right = rightNode;

        return rootNode;
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        TreeNode root = sortedArrayToBST(nums, 0, nums.length - 1);
        return root;
    }
}
