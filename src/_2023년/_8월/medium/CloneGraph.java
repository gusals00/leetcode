package _2023년._8월.medium;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class CloneGraph {
    public Node cloneGraph(Node node) {
        if(node == null)
            return null;

        Queue<Node> queue = new ArrayDeque<>();

        Node[] visited = new Node[101];
        Node copy = new Node(node.val);

        queue.add(node);
        visited[node.val] = copy;

        while(!queue.isEmpty()) {
            Node poll = queue.poll();

            poll.neighbors.forEach(neighbor -> {
                if(visited[neighbor.val] == null) {
                    visited[neighbor.val] = new Node(neighbor.val);
                    queue.add(neighbor);
                }
                visited[poll.val].neighbors.add(visited[neighbor.val]);
            });
        }
        return copy;
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

