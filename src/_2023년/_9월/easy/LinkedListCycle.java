package _2023년._9월.easy;

public class LinkedListCycle {
    public boolean hasCycle(ListNode head) {
        ListNode first = head;
        ListNode second = head;

        while(first != null && first.next != null) {
            first = first.next.next;
            second = second.next;

            if(first == second)
                return true;
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
