package _2023년._10월.medium;

public class RotateList {
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null)
            return null;

        ListNode result = new ListNode(0);
        ListNode last = result, node = result;
        result.next = head;
        int length = 0;

        while(last.next != null) {
            last = last.next;
            length++;
        }

        k %= length;
        k = length - k;
        for(int i=0; i<k; i++) {
            node = node.next;
        }

        last.next = result.next;
        result.next = node.next;
        node.next = null;

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
