package method;

import common.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Qbss
 * @date 2022/8/8
 * @desc
 */
public class Solution83 {


    public ListNode deleteDuplicates(ListNode head) {

        Set<Integer> set = new HashSet<>();
        ListNode listNode = head;
        while (listNode != null) {
            if (set.isEmpty()) {
                set.add(listNode.val);
            }
            if (listNode.next != null) {
                if (set.add(listNode.next.val)) {
                    listNode = listNode.next;
                } else {
                    listNode.next = listNode.next.next;
                }
            } else {
                break;
            }
        }
        return head;
    }

}
