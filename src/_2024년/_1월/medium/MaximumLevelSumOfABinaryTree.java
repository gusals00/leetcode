package _2024년._1월.medium;

import java.util.ArrayDeque;
import java.util.Queue;

public class MaximumLevelSumOfABinaryTree {
    public int maxLevelSum(TreeNode root) {
        if(root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        int maxSum = Integer.MIN_VALUE;
        int maxLevel = 1;
        int level = 0;

        while (!queue.isEmpty()) {
            level++;
            int size = queue.size();
            int sum = 0;

            for(int i=0; i<size; i++) {
                TreeNode remove = queue.remove();
                sum += remove.val;

                if(remove.left != null) {
                    queue.add(remove.left);
                }
                if(remove.right != null) {
                    queue.add(remove.right);
                }
            }
            if(sum > maxSum) {
                maxSum = sum;
                maxLevel = level;
            }
        }

        return maxLevel;
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
