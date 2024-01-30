package _2024년._1월.medium;

import java.util.HashMap;
import java.util.Map;

public class PathSumIII {
    Map<Long, Integer> map = new HashMap<>();
    int count = 0;
    public int pathSum(TreeNode root, int targetSum) {
        map.put(0L, 1);
        dfs(root, 0, targetSum);
        return count;
    }

    private void dfs(TreeNode node, long prevSum, int targetSum) {
        if(node == null) {
            return;
        }
        prevSum += node.val;
        if(map.containsKey(prevSum - targetSum)) {
            count += map.get(prevSum - targetSum);
        }
        map.put(prevSum, map.getOrDefault(prevSum,0) + 1);
        dfs(node.left, prevSum, targetSum);
        dfs(node.right, prevSum, targetSum);
        map.put(prevSum, map.get(prevSum)-1);
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
