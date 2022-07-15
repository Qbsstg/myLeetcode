package method;

import common.ListNode;

import java.util.Stack;

/**
 * @author Qbss
 * @date 2022/7/15
 * @desc
 */
public class Solution19 {

    public ListNode removeNthFromEnd(ListNode head, int n) {

        //head.setNext(head.getNext().getNext());

        ListNode fast = head;
        ListNode slow = head;
        for (int i = 0; i < n; i++) {
            fast = fast.getNext();
        }

        if (fast == null) {
            return head.getNext();
        }

        while (fast != null && fast.getNext() != null) {
            fast = fast.getNext();
            slow = slow.getNext();
        }
        slow.setNext(slow.getNext().getNext());
        return head;
    }

    public ListNode removeNthFromEnd1(ListNode head, int n) {

        Stack<ListNode> stack = new Stack<>();
        ListNode node = head;
        while (true) {
            stack.add(node);
            if (node.getNext() == null) {
                break;
            }
            node = node.getNext();
        }

        ListNode pre = null;
        while (n != 0) {
            pre = stack.pop();
            n--;
        }
        if (stack.isEmpty()){
            return null;
        }
        if (pre == null){
            stack.peek().setNext(null);
        }else {
            stack.peek().setNext(pre.getNext());
        }
        return head;
    }


}
