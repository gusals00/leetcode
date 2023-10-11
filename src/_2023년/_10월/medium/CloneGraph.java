package _2023년._10월.medium;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class CloneGraph {
    public Node cloneGraph(Node node) {
        if(node == null)
            return null;

        Deque<Node> deque = new ArrayDeque<>();
        Node[] check = new Node[101];

        check[node.val] = new Node(node.val);
        deque.add(node);

        while(!deque.isEmpty()) {
            int size = deque.size();

            for(int i=0; i<size; i++) {
                Node remove = deque.remove();
                for (Node neighbor : remove.neighbors) {
                    if(check[neighbor.val] == null) {
                        check[neighbor.val] = new Node(neighbor.val);
                        deque.add(neighbor);
                    }
                    check[remove.val].neighbors.add(check[neighbor.val]);
                }
            }
        }

        return check[node.val];
    }

    class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }
}
