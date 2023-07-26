package _2023년._7월.easy;

public class SymmetricTree {

    public boolean isSymmetric(TreeNode root) {
        return check(root.left, root.right);
    }

    private boolean check(TreeNode left, TreeNode right) {
        if(left == null && right == null)
            return true;

        if(left == null || right == null || left.val != right.val)
            return false;
        return check(left.left, right.right) && check(right.left, left.right);
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
