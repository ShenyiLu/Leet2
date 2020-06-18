package easy;

import helper.ListNode;

public class L203RemoveElements {
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        remove(dummyHead, val);
        return dummyHead.next;
    }

    private void remove(ListNode curr, int val) {
        if (curr == null || curr.next == null) {
            return;
        }

        ListNode next = curr.next;
        if (next.val != val) {
            remove(next, val);
            return;
        }
        while (next != null && next.val == val) {
            curr.next = next.next;
            next = curr.next;
        }

        remove(curr.next, val);
    }
}
