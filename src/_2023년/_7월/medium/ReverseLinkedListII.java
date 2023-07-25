package _2023년._7월.medium;

public class ReverseLinkedListII {

    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode start = new ListNode(0);
        start.next = head;
        ListNode prev = start;

        for(int i=0; i<left-1; i++) {
            prev = prev.next;
        }
        ListNode curr = prev.next;

        for(int i=0; i<right-left; i++) {
            ListNode next = curr.next;
            curr.next = next.next;
            next.next = prev.next;
            prev.next = next;
        }

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
