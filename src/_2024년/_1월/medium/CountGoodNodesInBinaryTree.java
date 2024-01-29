package _2024년._1월.medium;

public class CountGoodNodesInBinaryTree {
    int count = 0;
    public int goodNodes(TreeNode root) {
        dfs(root, root.val);
        return count;
    }

    private void dfs(TreeNode node, int max) {
        if(node == null) {
            return;
        }

        if(node.val >= max) {
            max = node.val;
            count++;
        }
        dfs(node.left, max);
        dfs(node.right, max);
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
