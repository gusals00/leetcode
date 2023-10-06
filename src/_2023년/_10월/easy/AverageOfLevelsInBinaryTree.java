package _2023년._10월.easy;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class AverageOfLevelsInBinaryTree {
    public List<Double> averageOfLevels(TreeNode root) {
        if(root == null)
            return null;

        List<Double> result = new ArrayList<>();
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.add(root);

        while(!deque.isEmpty()) {
            int size = deque.size();
            double count = 0;

            for(int i=0; i<size; i++) {
                TreeNode remove = deque.remove();
                count += remove.val;

                if(remove.left != null)
                    deque.add(remove.left);
                if(remove.right != null)
                    deque.add(remove.right);
            }

            result.add(count / size);
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
