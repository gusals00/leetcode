package _2023년._7월.medium;

public class PartitionList {

    public ListNode partition(ListNode head, int x) {
        ListNode result = head;
        ListNode lessHead = null, greaterHead = null;
        ListNode lessTail = head, greaterTail = head;

        while(head != null) {
            if(head.val < x) {
                if(lessHead == null) {
                    lessHead = head;
                    lessTail = lessHead;
                } else {
                    lessTail.next = head;
                    lessTail = head;
                }
            } else {
                if(greaterHead == null) {
                    greaterHead = head;
                    greaterTail = greaterHead;
                } else {
                    greaterTail.next = head;
                    greaterTail = head;
                }
            }
            head = head.next;
        }

        if(lessHead == null || greaterHead == null) {
            return result;
        }

        lessTail.next = greaterHead;
        greaterTail.next = null;
        return lessHead;
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
