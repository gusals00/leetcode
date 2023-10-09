package _2023년._10월.medium;

public class MinimumAbsoluteDifferenceInBST {

    private TreeNode prev = null;
    private int min = Integer.MAX_VALUE;

    public int getMinimumDifference(TreeNode root) {
        getMin(root);
        return min;
    }

    private void getMin(TreeNode node) {
        if(node == null)
            return;

        getMin(node.left);

        if(prev != null)
            min = Math.min(min, node.val - prev.val);
        prev = node;

        getMin(node.right);
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
