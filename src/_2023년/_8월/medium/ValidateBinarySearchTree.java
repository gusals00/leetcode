package _2023년._8월.medium;

import java.util.ArrayDeque;
import java.util.Deque;

public class ValidateBinarySearchTree {

    public boolean isValidBST(TreeNode root) {
        if(root == null)
            return true;

        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode prev = null;

        while(root != null || !stack.isEmpty()) {
            while(root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if(prev != null && root.val <= prev.val)
                return false;

            prev = root;
            root = root.right;
        }
        return true;
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
