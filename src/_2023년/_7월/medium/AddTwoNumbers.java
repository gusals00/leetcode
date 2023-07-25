package _2023년._7월.medium;

public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode last = head;
        int up = 0;

        while(l1 != null || l2 != null) {
            int sum = 0;
            if(l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if(l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            if(up == 1) {
                sum += 1;
                up = 0;
            }
            if(sum/10 == 1) {
                up = 1;
                sum = sum%10;
            }

            ListNode next = new ListNode(sum);
            last.next = next;
            last = last.next;
        }

        if(up == 1) {
            ListNode next = new ListNode(1);
            last.next = next;
            last = last.next;
        }

        return head.next;
    }

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
