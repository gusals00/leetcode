package _2023년._12월.easy;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class AverageOfLevelsInBinaryTree {
    public List<Double> averageOfLevels(TreeNode root) {
        if(root == null) {
            return null;
        }
        List<Double> result = new ArrayList<>();

        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);

        while(!queue.isEmpty()) {
            int size = queue.size();
            double sum = 0;

            for(int i=0; i<size; i++) {
                TreeNode remove = queue.remove();
                if(remove.left != null) {
                    queue.add(remove.left);
                }
                if(remove.right != null) {
                    queue.add(remove.right);
                }

                sum += remove.val;
            }
            result.add(sum/size);
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
