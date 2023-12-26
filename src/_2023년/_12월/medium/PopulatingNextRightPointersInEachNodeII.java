package _2023년._12월.medium;

import java.util.ArrayDeque;
import java.util.Queue;

public class PopulatingNextRightPointersInEachNodeII {
    public Node connect(Node root) {
        if(root == null) {
            return root;
        }

        Queue<Node> queue = new ArrayDeque<>();
        queue.add(root);

        while(!queue.isEmpty()) {
            int size = queue.size();
            Node nextNode = null;

            for(int i=0; i<size; i++) {
                Node remove = queue.remove();
                remove.next = nextNode;
                nextNode = remove;

                if(remove.right != null) {
                    queue.add(remove.right);
                }
                if(remove.left != null) {
                    queue.add(remove.left);
                }
            }
        }

        return root;
    }

    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }
}
