package method;

import common.ListNode;

import java.io.IOException;
import java.util.Stack;

/**
 * @author Qbss
 * @date 2022/7/20
 * @desc
 */
public class Solution206 {

    public ListNode reverseList(ListNode head) {

        ListNode node5 = new ListNode(5, null);
        ListNode node4 = new ListNode(4, node5);
        ListNode node3 = new ListNode(3, node4);
        ListNode node2 = new ListNode(2, node3);
        ListNode node1 = new ListNode(1, node2);

        Stack<ListNode> stack = new Stack<>();
        deal(stack, node1);

        //if (stack.isEmpty()){
        //    return new ListNode();
        //}

        //ListNode node = stack.peek();
        //int size = stack.size();
        //for (int i = 0; i < size; i++) {
        //    ListNode node1 = stack.pop();
        //    if (i< size -1){
        //        ListNode peek = stack.peek();
        //        peek.next = null;
        //        node1.next = peek;
        //    }
        //}


        int size = stack.size();

        for (int i = 0; i < size; i++) {
            ListNode pop = stack.pop();
            if (i< size -1){
                pop.next = stack.peek();
            }
        }
        return null;
    }

    private void deal(Stack<ListNode> stack, ListNode head) {
        if (head != null) {
            stack.push(head);
            deal(stack, head.next);
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
            ptr.next = new ListNode(item);
            ptr = ptr.next;
        }
        return dummyRoot.next;
    }

    public static String listNodeToString(ListNode node) {
        if (node == null) {
            return "[]";
        }

        String result = "";
        while (node != null) {
            result += Integer.toString(node.val) + ", ";
            node = node.next;
        }
        return "[" + result.substring(0, result.length() - 2) + "]";
    }

    public static void main(String[] args) throws IOException {
        //BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        //String line;
        //while ((line = in.readLine()) != null) {
        //    ListNode head = stringToListNode(line);
        //
        //    ListNode ret = new Solution206().reverseList(head);
        //
        //    String out = listNodeToString(ret);
        //
        //    System.out.print(out);
        //}
        ListNode ret = new Solution206().reverseList(null);
    }


}
