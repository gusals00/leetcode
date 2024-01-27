package _2024년._1월.medium;

import java.util.ArrayDeque;
import java.util.Deque;

public class MaximumTwinSumOfALinkedList {
    public int pairSum(ListNode head) {
        Deque<ListNode> stack = new ArrayDeque<>();
        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        while(slow != null) {
            stack.push(slow);
            slow = slow.next;
        }

        int max = 0;
        while(!stack.isEmpty()) {
            max = Math.max(max, head.val + stack.pop().val);
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
