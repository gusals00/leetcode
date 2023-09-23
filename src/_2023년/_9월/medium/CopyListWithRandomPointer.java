package _2023년._9월.medium;

import java.util.HashMap;
import java.util.Map;

public class CopyListWithRandomPointer {
    public Node copyRandomList(Node head) {
        if(head == null) return null;

        Node node = head;
        Map<Node, Node> map = new HashMap<>();
        while(node != null) {
            map.put(node, new Node(node.val));
            node = node.next;
        }

        node = head;
        while(node != null) {
            Node copyNode = map.get(node);
            copyNode.next = map.get(node.next);
            copyNode.random = map.get(node.random);
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
