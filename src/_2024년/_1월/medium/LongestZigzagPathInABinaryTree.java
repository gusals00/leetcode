package _2024년._1월.medium;

public class LongestZigzagPathInABinaryTree {
    int maxCount = 0;
    public int longestZigZag(TreeNode root) {
        dfs(root.left, 1, false);
        dfs(root.right, 1, true);

        return maxCount;
    }

    private void dfs(TreeNode node, int count, boolean nextIsLeft) {
        if(node == null) {
            return;
        }

        maxCount = Math.max(count, maxCount);

        if(nextIsLeft) {
            dfs(node.left, count+1, false);
            dfs(node.right, 1, true);
        } else {
            dfs(node.right, count+1, true);
            dfs(node.left, 1, false);
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
