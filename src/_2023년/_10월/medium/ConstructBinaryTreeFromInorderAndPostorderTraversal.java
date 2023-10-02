package _2023년._10월.medium;

import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTreeFromInorderAndPostorderTraversal {
    private Map<Integer, Integer> map = new HashMap<>();
    private int index = 0;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        for(int i=0; i<inorder.length; i++) {
            map.put(inorder[i], i);
        }

        return buildTree(postorder, 0, postorder.length-1);
    }

    private TreeNode buildTree(int[] postorder, int left, int right) {
        if(left > right) return null;

        int curr = postorder[postorder.length - 1 - index++];
        TreeNode node = new TreeNode(curr);
        node.right = buildTree(postorder, map.get(curr)+1, right);
        node.left = buildTree(postorder, left, map.get(curr)-1);

        return node;
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
