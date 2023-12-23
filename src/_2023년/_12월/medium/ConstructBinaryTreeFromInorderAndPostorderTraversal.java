package _2023년._12월.medium;

import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTreeFromInorderAndPostorderTraversal {
    private int index;
    private Map<Integer, Integer> map = new HashMap<>();
    
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        index = postorder.length - 1;
        for(int i=0; i<inorder.length; i++) {
            map.put(inorder[i], i);
        }

        return buildTree(postorder, 0, postorder.length-1);
    }

    private TreeNode buildTree(int[] postOrder, int left, int right) {
        if(left > right) {
            return null;
        }

        int curr = postOrder[index--];
        TreeNode node = new TreeNode(curr);
        node.right = buildTree(postOrder, map.get(curr)+1, right);
        node.left = buildTree(postOrder, left, map.get(curr)-1);

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
