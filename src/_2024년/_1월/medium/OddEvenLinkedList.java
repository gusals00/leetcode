package _2024년._1월.medium;

public class OddEvenLinkedList {
    public ListNode oddEvenList(ListNode head) {
        ListNode even = new ListNode(0);
        ListNode odd = new ListNode(0);
        ListNode oddHead = odd;
        ListNode evenHead = even;

        boolean flag = true;
        while(head != null) {
            if(flag) {
                odd.next = head;
                odd = odd.next;
            } else {
                even.next = head;
                even = even.next;
            }
            flag = !flag;
            head = head.next;
        }

        odd.next = evenHead.next;
        even.next = null;

        return oddHead.next;
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
