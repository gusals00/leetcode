package _2023년._8월.medium;

public class SumRootToLeafNumbers {

    public int sumNumbers(TreeNode root) {
        return dfs(root, 0);
    }

    private int dfs(TreeNode node, int sum) {
        if(node == null)
            return 0;

        sum = (sum*10) + node.val;

        int left = dfs(node.left, sum);
        int right = dfs(node.right, sum);

        if(left + right == 0) {
            return sum;
        } else {
            return left + right;
        }
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
