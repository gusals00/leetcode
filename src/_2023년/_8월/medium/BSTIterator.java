package _2023년._8월.medium;

import java.util.ArrayDeque;
import java.util.Deque;

public class BSTIterator {

    private Deque<TreeNode> deque;

    public BSTIterator(TreeNode root) {
        deque = new ArrayDeque<>();
        while(root != null) {
            deque.push(root);
            root = root.left;
        }
    }

    public int next() {
        TreeNode pop = deque.pop();
        int result = pop.val;
        if(pop.right != null) {
            pop = pop.right;
            while(pop != null) {
                deque.push(pop);
                pop = pop.left;
            }
        }

        return result;
    }

    public boolean hasNext() {
        return !deque.isEmpty();
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
