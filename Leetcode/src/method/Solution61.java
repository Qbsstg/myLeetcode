package method;

import common.ListNode;

/**
 * @author Qbss
 * @date 2021/3/27
 * @desc
 */
public class Solution61 {

    public static void main(String[] args) {
        ListNode node = new ListNode(1, new ListNode(2, new ListNode(3)));
//        ListNode node1 = rotateOne(node);
        int k = 200000000;
        System.out.println(rotateRight(node, k));
    }


    public static ListNode rotateRight(ListNode head, int k) {

        int size = getSize(head);

        if (k % size == 0) {
            return head;
        } else {
            k = k % size;
        }

        while (k > 0) {
            head = rotateOne(head);
            k--;
        }
        return head;

    }


    private static ListNode rotateOne(ListNode head) {


//        if (head.getNext() != null) {
//            ListNode next = head.getNext();
//            ListNode node = new ListNode(next.getVal(), next.getNext());
//
//            next = node.getNext();
//
//            while (next != null) {
//                if (next.getNext() == null) {
//                    next.setNext(new ListNode(head.getVal()));
//                    break;
//                } else {
//                    next = next.getNext();
//                }
//            }
//            return node;
//        }


        if (head.getNext() != null) {

            ListNode next = head.getNext();
            ListNode preNode = head;
            while (next != null) {
                if (next.getNext() == null) {
                    ListNode node = new ListNode(next.getVal());
                    preNode.setNext(null);
                    node.setNext(head);
                    return node;
                } else {
                    preNode = preNode.getNext();
                    next = next.getNext();
                }
            }


        }
        return head;
    }

    private static int getSize(ListNode head) {

        if (head == null) {
            return 0;
        }
        int i = 1;
        ListNode next = head.getNext();
        while (next != null) {
            i++;
            if (next.getNext() != null) {
                next = next.getNext();
            } else {
                return i;
            }

        }
        return i;

    }


}
