package _2023년._8월.easy;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class AverageOfLevelsInBinaryTree {

    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> result = new ArrayList<>();
        Queue<TreeNode> queue = new ArrayDeque<>();
        if(root != null) {
            queue.add(root);
        }

        while(!queue.isEmpty()) {
            double count = 0;
            int size = queue.size();

            for(int i=0; i<size; i++) {
                TreeNode pop = queue.poll();
                count += pop.val;
                if(pop.left != null) {
                    queue.add(pop.left);
                }
                if(pop.right != null) {
                    queue.add(pop.right);
                }
            }
            result.add(count/size);
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
