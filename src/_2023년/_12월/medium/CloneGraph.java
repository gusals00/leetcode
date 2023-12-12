package _2023년._12월.medium;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class CloneGraph {
    public Node cloneGraph(Node node) {
        if(node == null)
            return null;

        Node[] nodes = new Node[101];
        Queue<Node> queue = new ArrayDeque<>();

        nodes[node.val] = new Node(node.val);
        queue.add(node);
        
        while(!queue.isEmpty()) {
            Node remove = queue.remove();
            for (Node neighbor : remove.neighbors) {
                if(nodes[neighbor.val] == null) {
                    nodes[neighbor.val] = new Node(neighbor.val);
                    queue.add(neighbor);
                }
                nodes[remove.val].neighbors.add(nodes[neighbor.val]);
            }
        }

        return nodes[node.val];
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
