package _2023년._12월.medium;

public class RotateList {
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null)
            return null;

        int length = 0;
        ListNode result = new ListNode(0);
        ListNode last = result, node = result;
        result.next = head;

        while(last.next != null) {
            last = last.next;
            length++;
        }

        k %= length;
        for(int i=0; i<length-k; i++) {
            node = node.next;
        }
        last.next = head;
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
