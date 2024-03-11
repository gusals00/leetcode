package _2024년._3월.medium;

import java.util.ArrayDeque;
import java.util.Queue;

public class MaximumLevelSumOfABinaryTree {
    public int maxLevelSum(TreeNode root) {
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        int max = Integer.MIN_VALUE;
        int level = 1;
        int maxLevel = 1;

        while (!queue.isEmpty()) {
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

            if(sum > max) {
                max = sum;
                maxLevel = level;
            }

            level++;
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
