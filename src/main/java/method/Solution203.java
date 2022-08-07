package method;

import common.ListNode;

public class Solution203 {

    public ListNode removeElements(ListNode head, int val) {

        ListNode listNode = head;
        while (true) {
            if (listNode != null && listNode.next != null) {
                if (listNode.next.val == val) {
                    listNode.next = listNode.next.next;
                } else {
                    listNode = listNode.next;
                }
            } else {
                break;
            }
        }
        if (head != null && head.val == val) {
            return head.next;
        }
        return head;

    }

}
