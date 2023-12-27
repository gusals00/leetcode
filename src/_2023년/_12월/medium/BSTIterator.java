package _2023년._12월.medium;

import java.util.ArrayDeque;
import java.util.Deque;

class BSTIterator {
    Deque<TreeNode> stack;

    public BSTIterator(TreeNode root) {
        stack = new ArrayDeque<>();
        while(root != null) {
            stack.push(root);
            root = root.left;
        }
    }

    public int next() {
        TreeNode pop = stack.pop();
        int next = pop.val;

        pop = pop.right;
        while(pop != null) {
            stack.push(pop);
            pop = pop.left;
        }

        return next;
    }

    public boolean hasNext() {
        return !stack.isEmpty();
    }

    static class TreeNode {
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
