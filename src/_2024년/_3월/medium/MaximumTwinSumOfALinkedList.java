package _2024년._3월.medium;

import java.util.ArrayDeque;
import java.util.Deque;

public class MaximumTwinSumOfALinkedList {
    public int pairSum(ListNode head) {
        Deque<Integer> stack = new ArrayDeque<>();
        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        while(slow != null) {
            stack.push(slow.val);
            slow = slow.next;
        }

        int max = 0;
        while(!stack.isEmpty()) {
            max = Math.max(max, stack.pop() + head.val);
            head = head.next;
        }

        return max;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
