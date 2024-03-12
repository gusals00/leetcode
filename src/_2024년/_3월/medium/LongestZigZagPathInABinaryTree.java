package _2024년._3월.medium;

public class LongestZigZagPathInABinaryTree {
    int maxLength = 0;
    public int longestZigZag(TreeNode root) {
        dfs(root.left, 1, true);
        dfs(root.right, 1, false);

        return maxLength;
    }

    private void dfs(TreeNode node, int count, boolean isLeft) {
        if(node == null) {
            return;
        }

        maxLength = Math.max(maxLength, count);
        if(isLeft) {
            dfs(node.right, count+1, false);
            dfs(node.left, 1, true);
        } else {
            dfs(node.left, count+1, true);
            dfs(node.right, 1, false);
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
