package _2023년._10월.medium;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    class Node {
        int key;
        int value;
        Node prev;
        Node next;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    Node head;
    Node tail;
    int capacity;
    Map<Integer, Node> map;

    public LRUCache(int capacity) {
        head = null;
        tail = null;
        this.capacity = capacity;
        map = new HashMap<>();
    }

    public int get(int key) {
        if(!map.containsKey(key))
            return -1;
        else {
            Node curr = map.get(key);

            if(curr != head) {
                if(curr == tail)
                    tail = tail.prev;
                if(curr.prev != null)
                    curr.prev.next = curr.next;
                if(curr.next != null)
                    curr.next.prev = curr.prev;

                curr.next = head;
                head.prev = curr;
                curr.prev = null;

                head = curr;
            }

            return curr.value;
        }
    }

    public void put(int key, int value) {
        if(get(key) == -1) {
            Node curr = new Node(key,value);

            if(head == null) {
                head = curr;
                tail = curr;
            } else {
                curr.next = head;
                head.prev = curr;
                head = curr;
            }

            map.put(key, curr);
        }

        if(map.size() > capacity) {
            map.remove(tail.key);
            tail.prev.next = null;
            tail = tail.prev;
        } else {
            map.get(key).value = value;
        }
    }
}
