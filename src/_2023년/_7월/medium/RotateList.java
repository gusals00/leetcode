package _2023년._7월.medium;

public class RotateList {

    public ListNode rotateRight(ListNode head, int k) {
        if(head == null) return head;
        ListNode result = new ListNode(0);
        result.next = head;
        ListNode fast = result, slow = result;

        int cnt = 0;
        while(fast.next != null) {
            fast = fast.next;
            cnt++;
        }

        k %= cnt;
        k = cnt - k;
        while(k > 0) {
            slow = slow.next;
            k--;
        }

        fast.next = result.next;
        result.next = slow.next;
        slow.next = null;

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
