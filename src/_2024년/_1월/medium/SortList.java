package _2024년._1월.medium;

public class SortList {
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }

        ListNode prev = null;
        ListNode fast = head;
        ListNode slow = head;

        while(fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        prev.next = null;
        ListNode left = sortList(head);
        ListNode right = sortList(slow);

        return merge(left, right);
    }

    private ListNode merge(ListNode left, ListNode right) {
        ListNode result = new ListNode(0);
        ListNode merge = result;

        while(left != null && right != null) {
            if(left.val < right.val) {
                merge.next =  left;
                left = left.next;
            } else {
                merge.next = right;
                right = right.next;
            }
            merge = merge.next;
        }

        if(left != null) {
            merge.next = left;
        } else if(right != null){
            merge.next = right;
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
