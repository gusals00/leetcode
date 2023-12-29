package _2023년._12월.medium;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) {
            return result;
        }

        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);

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
