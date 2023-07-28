package _2023년._7월.medium;

public class RemoveDuplicatesFromSortedListII {

    public ListNode deleteDuplicates(ListNode head) {
        ListNode result = new ListNode(0);
        ListNode fast=head, slow = result;
        slow.next = head;

        while(fast != null) {
            while(fast.next != null && fast.next.val == fast.val)
                fast = fast.next;

            if(slow.next != fast) {
                slow.next = fast.next;
                fast = slow.next;
            } else {
                fast = fast.next;
                slow = slow.next;
            }
        }

        return result.next;
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
