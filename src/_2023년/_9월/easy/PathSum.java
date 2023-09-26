package _2023년._9월.easy;

public class PathSum {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        return check(root, 0, targetSum);
    }

    private boolean check(TreeNode root, int currentSum, int targetSum) {
        if(root == null)
            return false;

        currentSum += root.val;
        if(currentSum == targetSum && root.left == null && root.right == null)
            return true;

        return check(root.left, currentSum, targetSum) || check(root.right, currentSum, targetSum);
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
