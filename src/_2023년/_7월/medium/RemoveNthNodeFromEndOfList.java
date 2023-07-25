package _2023년._7월.medium;

public class RemoveNthNodeFromEndOfList {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode start = new ListNode(0);
        ListNode first = start, second = start;
        start.next = head;

        for(int i=1; i<=n+1; i++) {
            first = first.next;
        }

        while(first != null) {
            second = second.next;
            first = first.next;
        }

        second.next = second.next.next;
        return start.next;
    }

    class ListNode {
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
