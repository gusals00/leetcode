package _2023년._8월.medium;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new ArrayDeque<>();
        if(root != null) {
            queue.add(root);
        }

        while(!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            for(int i=0; i<size; i++) {
                TreeNode poll = queue.poll();
                list.add(poll.val);
                if(poll.left != null)
                    queue.add(poll.left);
                if(poll.right != null)
                    queue.add(poll.right);
            }
            result.add(list);
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
