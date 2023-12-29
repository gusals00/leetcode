package _2023년._12월.medium;

import java.util.*;

public class BinaryTreeZigzagLevelOrderTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) {
            return result;
        }

        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);

        boolean flag = false;
        while(!queue.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            int size = queue.size();

            for(int i=0; i<size; i++) {
                TreeNode remove = queue.remove();
                list.add(remove.val);
                if(remove.left != null) {
                    queue.add(remove.left);
                }
                if(remove.right != null) {
                    queue.add(remove.right);
                }
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
