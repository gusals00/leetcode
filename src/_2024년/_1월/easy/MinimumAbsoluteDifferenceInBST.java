package _2024년._1월.easy;

public class MinimumAbsoluteDifferenceInBST {
    private TreeNode prev = null;
    private int min = Integer.MAX_VALUE;

    public int getMinimumDifference(TreeNode root) {
        if(root == null) {
            return min;
        }

        getMinimumDifference(root.left);

        if(prev != null) {
            min = Math.min(min, root.val - prev.val);
        }
        prev = root;

        getMinimumDifference(root.right);

        return min;
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
