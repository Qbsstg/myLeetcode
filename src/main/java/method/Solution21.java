package method;

import common.ListNode;

/**
 * @author Qbss
 * @date 2022/7/20
 * @desc
 */
public class Solution21 {

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        ListNode node = new ListNode();
        deal(node, list1, list2);
        return node.next;
    }

    private void deal(ListNode node, ListNode list1, ListNode list2) {

        if (list1 == null) {
            node.next = list2;
            return;
        }
        if (list2 == null) {
            node.next = list1;
            return;
        }

        int val1 = list1.val;
        int val2 = list2.val;
        if (val2 >= val1) {
            node.next = list1;
            deal(node.next, list1.next, list2);
        } else {
            node.next = list2;
            deal(node.next, list1, list2.next);
        }
    }

}
