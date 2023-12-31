package _2023년._8월.easy;

public class ConvertSortedArrayToBinarySearchTree {

    public TreeNode sortedArrayToBST(int[] nums) {
        return recur(nums, 0, nums.length-1);
    }

    private TreeNode recur(int nums[], int left, int right) {
        if(left > right) {
            return null;
        }

        int mid = (left+right) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = recur(nums, left, mid-1);
        node.right = recur(nums, mid+1, right);

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
