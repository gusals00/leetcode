package _2023년._12월.medium;

public class SumRootToLeafNumbers {
    public int sumNumbers(TreeNode root) {
        return sumNumbers(root, 0);
    }

    private int sumNumbers(TreeNode node, int sum) {
        if(node == null)
            return 0;

        sum = sum*10 + node.val;

        int left = sumNumbers(node.left, sum);
        int right = sumNumbers(node.right, sum);

        if(left + right == 0) {
            return sum;
        }
        else {
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
