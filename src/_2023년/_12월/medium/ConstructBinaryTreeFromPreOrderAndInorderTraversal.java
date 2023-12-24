package _2023년._12월.medium;

import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTreeFromPreOrderAndInorderTraversal {
    private int index;
    private Map<Integer, Integer> map = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for(int i=0; i<inorder.length; i++) {
            map.put(inorder[i], i);
        }

        return buildTree(preorder, 0, preorder.length-1);
    }

    private TreeNode buildTree(int[] preorder, int left, int right) {
        if(left > right) {
            return null;
        }

        int curr = preorder[index++];
        TreeNode node = new TreeNode(curr);
        node.left = buildTree(preorder, left, map.get(curr)-1);
        node.right = buildTree(preorder, map.get(curr)+1, right);

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
