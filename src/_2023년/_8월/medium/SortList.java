package _2023년._8월.medium;

public class SortList {
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }

        ListNode prev = null;
        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        prev.next = null;

        ListNode l  = sortList(head);
        ListNode l2 = sortList(slow);

        return merge(l, l2);
    }

    private ListNode merge(ListNode l, ListNode l2) {
        ListNode result = new ListNode(0);
        ListNode q = result;

        while(l != null && l2 != null) {
            if(l.val < l2.val) {
                q.next = l;
                l = l.next;
            } else {
                q.next = l2;
                l2 = l2.next;
            }
            q = q.next;
        }

        if(l != null)
            q.next = l;
        if(l2 != null)
            q.next = l2;

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
