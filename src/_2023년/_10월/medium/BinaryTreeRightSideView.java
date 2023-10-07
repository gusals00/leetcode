package _2023년._10월.medium;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class BinaryTreeRightSideView {
    public List<Integer> rightSideView(TreeNode root) {
        if(root == null)
            return new ArrayList<>();

        List<Integer> result = new ArrayList<>();
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.add(root);

        while(!deque.isEmpty()) {
            int size = deque.size();
            result.add(deque.getLast().val);

            for(int i=0; i<size; i++) {
                TreeNode remove = deque.remove();

                if(remove.left != null) {
                    deque.add(remove.left);
                }
                if(remove.right != null) {
                    deque.add(remove.right);
                }
            }
        }

        return result;
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
