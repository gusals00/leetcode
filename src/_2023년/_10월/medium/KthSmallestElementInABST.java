package _2023년._10월.medium;

import java.util.ArrayDeque;
import java.util.Deque;

public class KthSmallestElementInABST {
    public int kthSmallest(TreeNode root, int k) {
        Deque<TreeNode> deque = new ArrayDeque<>();

        while(root != null || !deque.isEmpty()) {
            if(root != null) {
                deque.push(root);
                root = root.left;
            } else {
                root = deque.pop();
                k--;
                if(k == 0) {
                    return root.val;
                }
                root = root.right;
            }
        }

        return -1;
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
