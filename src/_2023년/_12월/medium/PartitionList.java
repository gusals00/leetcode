package _2023년._12월.medium;

public class PartitionList {
    public ListNode partition(ListNode head, int x) {
        ListNode lesserHead = new ListNode(0);
        ListNode greaterHead = new ListNode(0);
        ListNode lesserNode = lesserHead;
        ListNode greaterNode = greaterHead;

        while(head != null) {
            if(head.val < x) {
                lesserNode.next = head;
                lesserNode = lesserNode.next;
            } else {
                greaterNode.next = head;
                greaterNode = greaterNode.next;
            }

            head = head.next;
        }

        lesserNode.next = greaterHead.next;
        greaterNode.next = null;
        return lesserHead.next;
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
