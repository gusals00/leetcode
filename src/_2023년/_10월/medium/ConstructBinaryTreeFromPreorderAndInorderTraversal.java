package _2023년._10월.medium;

import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTreeFromPreorderAndInorderTraversal {

    private Map<Integer, Integer> map = new HashMap<>();
    private int index = 0;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for(int i=0; i<inorder.length; i++) {
            map.put(inorder[i], i);
        }

        return buildTree(0, preorder.length-1, preorder);
    }

    private TreeNode buildTree(int left, int right, int[] preorder) {
        if(left > right) return null;

        int curr = preorder[index++];
        TreeNode treeNode = new TreeNode(curr);
        treeNode.left = buildTree(left, map.get(curr)-1, preorder);
        treeNode.right = buildTree(map.get(curr)+1, right, preorder);

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
