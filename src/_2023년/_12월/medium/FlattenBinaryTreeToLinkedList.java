package _2023년._12월.medium;

public class FlattenBinaryTreeToLinkedList {
    TreeNode prevNode = null;

    public void flatten(TreeNode root) {
        if(root == null) {
            return;
        }

        flatten(root.right);
        flatten(root.left);

        root.right = prevNode;
        prevNode = root;
        root.left = null;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
