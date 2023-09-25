package _2023년._9월.medium;

public class ReverseLinkedListII {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode result = new ListNode(0);
        result.next = head;
        ListNode prev = result;

        for(int i=0; i<left-1; i++) {
            prev = prev.next;
        }

        ListNode curr = prev.next;
        for(int i=0; i<right-left; i++) {
            ListNode nextNode = curr.next;
            curr.next = nextNode.next;
            nextNode.next = prev.next;
            prev.next = nextNode;
        }

        return result.next;
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
