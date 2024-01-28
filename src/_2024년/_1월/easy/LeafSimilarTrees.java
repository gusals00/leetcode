package _2024년._1월.easy;

import java.util.ArrayList;
import java.util.List;

public class LeafSimilarTrees {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> root1List = new ArrayList<>();
        List<Integer> root2List = new ArrayList<>();
        dfs(root1, root1List);
        dfs(root2, root2List);

        return root1List.equals(root2List);
    }

    private void dfs(TreeNode root, List<Integer> list) {
        if(root == null) {
            return;
        }
        if(root.left == null && root.right == null) {
            list.add(root.val);
        } else {
            dfs(root.left, list);
            dfs(root.right, list);
        }
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
