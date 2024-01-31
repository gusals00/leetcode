package _2024년._1월.medium;

public class DeleteNodeInABST {
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null) {
            return null;
        }

        if(key < root.val) {
            root.left = deleteNode(root.left, key);
            return root;
        } else if(key > root.val) {
            root.right = deleteNode(root.right, key);
            return root;
        } else {
            if(root.left == null) {
                return root.right;
            } else if(root.right == null) {
                return root.left;
            } else {
                TreeNode minNode = root.right;
                while(minNode.left != null) {
                    minNode = minNode.left;
                }
                root.val = minNode.val;
                root.right = deleteNode(root.right, minNode.val);
                return root;
            }
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
