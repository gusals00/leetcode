package _2023년._8월.medium;

public class KthSmallestElementInABST {

    private int cnt = 0;
    private int result = 0;

    public int kthSmallest(TreeNode root, int k) {
        dfs(root, k);
        return result;
    }

    private void dfs(TreeNode node, int k) {
        if(node == null)
            return;

        dfs(node.left, k);

        cnt++;
        if(k == cnt) {
            result = node.val;
            return;
        }

        dfs(node.right, k);
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
