package _2023년._8월.easy;

public class MinimumAbsoluteDifferenceInBST {

    private TreeNode prev = null;
    private int minDiff = Integer.MAX_VALUE;

    public int getMinimumDifference(TreeNode root) {
        dfs(root);
        return minDiff;
    }

    private void dfs(TreeNode node) {
        if(node == null)
            return;

        dfs(node.left);
        if(prev != null)
            minDiff = Math.min(minDiff, node.val - prev.val);
        prev=node;
        dfs(node.right);
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
