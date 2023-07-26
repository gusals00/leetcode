package _2023년._7월.easy;

public class PathSum {

    public boolean hasPathSum(TreeNode root, int targetSum) {
        return checkSum(root, 0, targetSum);
    }

    private boolean checkSum(TreeNode root, int sum, int targetSum) {
        if(root == null) {
            return false;
        }
        int check = sum + root.val;
        if(root.left == null && root.right == null) {
            if(check == targetSum)
                return true;
        }
        return checkSum(root.left, check, targetSum) || checkSum(root.right, check, targetSum);
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
