package _2023년._7월.easy;

public class LinkedListCycle {

    public boolean hasCycle(ListNode head) {
        ListNode first = head, second = head;

        while(first != null && first.next != null) {
            first = first.next.next;
            second = second.next;

            if(first == second) {
                return true;
            }
        }
        return false;
    }

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
