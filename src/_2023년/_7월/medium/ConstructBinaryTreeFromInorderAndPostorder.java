package _2023년._7월.medium;

import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTreeFromInorderAndPostorder {

    private Map<Integer, Integer> map = new HashMap<>();
    private int index = 0;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        for(int i=0; i<inorder.length; i++) {
            map.put(inorder[i], i);
        }

        return dfs(0, inorder.length-1, map, postorder);
    }

    private TreeNode dfs(int left, int right, Map<Integer,Integer> map, int[] postorder) {
        if(left > right)
            return null;

        int current = postorder[postorder.length -1 - index++];
        TreeNode treeNode = new TreeNode(current);
        treeNode.right = dfs(map.get(current)+1, right, map, postorder);
        treeNode.left = dfs(left, map.get(current)-1, map, postorder);

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
