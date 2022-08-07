package method;

import common.ListNode;

import java.util.HashSet;
import java.util.Set;

public class Solution141 {

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        ListNode listNode1 = new ListNode(2);

        listNode.next = listNode1;
        listNode1.next = listNode;

        boolean equals = listNode.equals(listNode.next.next);
        System.out.println(equals);


    }

    public boolean hasCycle(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        ListNode head1 = head;
        while (head1 != null) {
            if (!set.add(head1)) {
                return true;
            } else {
                head1 = head1.next;
            }
        }
        return false;
    }

}
