package method;

import common.ListNode;

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


}
