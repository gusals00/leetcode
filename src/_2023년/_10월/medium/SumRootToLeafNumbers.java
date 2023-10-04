package _2023년._10월.medium;

public class SumRootToLeafNumbers {
    public int sumNumbers(TreeNode root) {
        return sumNumbers(root, 0);
    }

    private int sumNumbers(TreeNode node, int num) {
        if(node == null)
            return 0;

        num = num*10 + node.val;
        int left = sumNumbers(node.left, num);
        int right = sumNumbers(node.right, num);

        if(left + right == 0)
            return num;
        else
            return left + right;
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
