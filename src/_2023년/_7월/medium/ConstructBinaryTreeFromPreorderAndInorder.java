package _2023년._7월.medium;

import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTreeFromPreorderAndInorder {

    private Map<Integer, Integer> map = new HashMap<>();
    private int index = 0;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for(int i=0; i<inorder.length; i++) {
            map.put(inorder[i], i);
        }

        return dfs(0, inorder.length-1, map, preorder);
    }

    private TreeNode dfs(int left, int right, Map<Integer,Integer> map, int[] preOrder) {
        if(left > right)
            return null;

        int current = preOrder[index++];
        TreeNode treeNode = new TreeNode(current);
        treeNode.left = dfs(left, map.get(current)-1, map, preOrder);
        treeNode.right = dfs(map.get(current)+1, right, map, preOrder);

        return treeNode;
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
