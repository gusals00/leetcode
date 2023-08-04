package _2023년._8월.medium;

import java.util.*;

public class BinaryTreeZigzagLevelOrderTraversal {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new ArrayDeque<>();
        if(root != null) {
            queue.add(root);
        }

        boolean flag = false;

        while(!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            for(int i=0; i<size; i++) {
                TreeNode poll = queue.poll();
                list.add(poll.val);
                if (poll.left != null)
                    queue.add(poll.left);
                if (poll.right != null)
                    queue.add(poll.right);
            }

            if(flag) {
                Collections.reverse(list);
            }
            flag = !flag;
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
