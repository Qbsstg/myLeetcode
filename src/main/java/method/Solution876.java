package method;

import common.ListNode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Qbss
 * @date 2022/7/15
 * @desc
 */
public class Solution876 {

    public ListNode middleNode1(ListNode head) {

        ListNode nodeJ = head;
        while (true) {
            if (nodeJ.getNext() == null){
                break;
            }else {
                if (nodeJ.getNext().getNext() == null){
                    head = head.getNext();
                    break;
                }else {
                    nodeJ = nodeJ.getNext().getNext();
                }
            }
            head = head.getNext();
        }
        return head;

    }


    public ListNode middleNode(ListNode head) {

        List<Integer> values = new ArrayList<>();
        getValues(head, values);
        int mid = values.size() / 2;
        ListNode node = head;
        for (int i = 0; i < mid; i++) {
            node = node.getNext();
        }
        return node;
    }

    private void getValues(ListNode head, List<Integer> values) {
        values.add(head.getVal());
        if (head.getNext() != null) {
            getValues(head.getNext(), values);
        }
    }

    public static int[] stringToIntegerArray(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
            return new int[0];
        }

        String[] parts = input.split(",");
        int[] output = new int[parts.length];
        for (int index = 0; index < parts.length; index++) {
            String part = parts[index].trim();
            output[index] = Integer.parseInt(part);
        }
        return output;
    }

    public static ListNode stringToListNode(String input) {
        // Generate array from the input
        int[] nodeValues = stringToIntegerArray(input);

        // Now convert that list into linked list
        ListNode dummyRoot = new ListNode(0);
        ListNode ptr = dummyRoot;
        for (int item : nodeValues) {
            ptr.setNext(new ListNode(item));
            ptr = ptr.getNext();
        }
        return dummyRoot.getNext();
    }

    public static String listNodeToString(ListNode node) {
        if (node == null) {
            return "[]";
        }

        String result = "";
        while (node != null) {
            result += node.getVal() + ", ";
            node = node.getNext();
        }
        return "[" + result.substring(0, result.length() - 2) + "]";
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            ListNode head = stringToListNode(line);

            ListNode ret = new Solution876().middleNode1(head);

            String out = listNodeToString(ret);

            System.out.print(out);
        }
    }


}
