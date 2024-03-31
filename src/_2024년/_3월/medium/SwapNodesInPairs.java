package _2024년._3월.medium;

public class SwapNodesInPairs {
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }

        ListNode result = head.next;

        ListNode curr = head;
        while(curr != null && curr.next != null) {
            ListNode temp = curr;
            curr = curr.next;
            temp.next = curr.next;
            curr.next = temp;

            curr = temp.next;
            if(curr != null && curr.next != null) {
                temp.next = curr.next;
            }
        }

        return result;
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
