package medium;

import helper.ListNode;

import java.util.EmptyStackException;
import java.util.Stack;

public class L445AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> l1Stack = new Stack<>();
        Stack<Integer> l2Stack = new Stack<>();
        while (l1 != null) {
            l1Stack.push(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            l2Stack.push(l2.val);
            l2 = l2.next;
        }

        int increment = 0;

        ListNode dummyHead = new ListNode(0);
        while (!l1Stack.isEmpty() || !l2Stack.isEmpty()) {
            int l1Val;
            int l2Val;
            int sum;
            try {
                l1Val = l1Stack.pop();
            } catch (EmptyStackException e) {
                l1Val = 0;
            }
            try {
                l2Val = l2Stack.pop();
            } catch (EmptyStackException e) {
                l2Val = 0;
            }
            sum = l1Val + l2Val + increment;
            ListNode temp = new ListNode(sum % 10);
            temp.next = dummyHead.next;
            dummyHead.next = temp;
            increment = (sum - sum % 10) / 10;
        }
        if (increment > 0) {
            ListNode temp = new ListNode(increment);
            temp.next = dummyHead.next;
            dummyHead.next = temp;
        }
        return dummyHead.next;
    }
}
