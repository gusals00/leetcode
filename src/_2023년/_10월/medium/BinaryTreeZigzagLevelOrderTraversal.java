package _2023년._10월.medium;

import java.util.*;

public class BinaryTreeZigzagLevelOrderTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if(root == null)
            return new ArrayList<>();

        List<List<Integer>> result = new ArrayList<>();
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.add(root);

        boolean flag = false;

        while(!deque.isEmpty()) {
            int size = deque.size();
            List<Integer> list = new ArrayList<>();

            for(int i=0; i<size; i++) {
                TreeNode remove = deque.remove();

                if(remove.left != null)
                    deque.add(remove.left);
                if(remove.right != null)
                    deque.add(remove.right);

                list.add(remove.val);
            }
            if(flag)
                Collections.reverse(list);

            result.add(list);
            flag = !flag;
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
