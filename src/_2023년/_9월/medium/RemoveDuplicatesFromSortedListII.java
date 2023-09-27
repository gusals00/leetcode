package _2023년._9월.medium;

public class RemoveDuplicatesFromSortedListII {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode result = new ListNode(0);
        result.next = head;
        ListNode fast = head, slow = result;

        while(fast != null) {
            while(fast.next != null && fast.next.val == fast.val) {
                fast = fast.next;
            }

            if(slow.next != fast) {
                slow.next = fast.next;
                fast = slow.next;
            } else {
                slow = slow.next;
                fast = fast.next;
            }
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
