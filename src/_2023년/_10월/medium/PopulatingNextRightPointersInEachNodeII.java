package _2023년._10월.medium;

import java.util.ArrayDeque;
import java.util.Deque;

public class PopulatingNextRightPointersInEachNodeII {
    public Node connect(Node root) {
        if(root == null)
            return null;

        Deque<Node> deque = new ArrayDeque<>();
        deque.add(root);

        while(!deque.isEmpty()) {
            Node nextNode = null;
            int size = deque.size();

            for(int i=0; i<size; i++) {
                Node pop = deque.remove();
                pop.next = nextNode;
                nextNode = pop;

                if(pop.right != null)
                    deque.add(pop.right);
                if(pop.left != null)
                    deque.add(pop.left);
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
