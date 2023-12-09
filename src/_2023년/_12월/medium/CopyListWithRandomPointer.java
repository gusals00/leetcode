package _2023년._12월.medium;

import java.util.HashMap;
import java.util.Map;

public class CopyListWithRandomPointer {
    public Node copyRandomList(Node head) {
        Map<Node, Node> map = new HashMap<>();
        Node node = head;
        while(node != null) {
            map.put(node, new Node(node.val));
            node = node.next;
        }

        node = head;
        while (node != null) {
            Node copy = map.get(node);
            copy.next = map.get(node.next);
            copy.random = map.get(node.random);
            node = node.next;
        }

        return map.get(head);
    }

    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
}
