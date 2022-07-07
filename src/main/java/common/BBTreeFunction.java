package common;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * @author Qbss
 * @date 2022/7/7
 * @desc
 */
public class BBTreeFunction {

    public List<Integer> inorderTraversal(BBTreeNode bbTreeNode) {
        List<Integer> list = new ArrayList<>();
        inorderTraversal(bbTreeNode, list);
        return list;
    }

    public void inorderTraversal(BBTreeNode bbTreeNode, List<Integer> values) {

        if (bbTreeNode == null) {
            return;
        }
        //if (bbTreeNode.getLeftNode() != null) {
        //    inorderTraversal(bbTreeNode.getLeftNode(), values);
        //    if (bbTreeNode.getRightNode() == null) {
        //        values.add(bbTreeNode.getValue());
        //    }
        //}
        //if (bbTreeNode.getRightNode() != null) {
        //    values.add(bbTreeNode.getValue());
        //    inorderTraversal(bbTreeNode.getRightNode(), values);
        //}
        //if (bbTreeNode.getLeftNode() == null && bbTreeNode.getRightNode() == null) {
        //    values.add(bbTreeNode.getValue());
        //}

        inorderTraversal(bbTreeNode.getLeftNode(), values);
        values.add(bbTreeNode.getValue());
        inorderTraversal(bbTreeNode.getRightNode(), values);

    }

    public List<Integer> inorderTraversalDeque(BBTreeNode root) {
        List<Integer> res = new ArrayList<>();

        Deque<BBTreeNode> stk = new LinkedList<>();
        while (root != null || !stk.isEmpty()) {
            while (root != null) {
                stk.push(root);
                root = root.getLeftNode();
            }
            root = stk.pop();
            res.add(root.getValue());
            root = root.getRightNode();
        }
        return res;
    }

    public static BBTreeNode stringToTreeNode(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
            return null;
        }

        String[] parts = input.split(",");
        String item = parts[0];
        BBTreeNode root = new BBTreeNode(Integer.parseInt(item));
        Queue<BBTreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.add(root);

        int index = 1;
        while (!nodeQueue.isEmpty()) {
            BBTreeNode node = nodeQueue.remove();

            if (index == parts.length) {
                break;
            }

            item = parts[index++];
            item = item.trim();
            if (!item.equals("null")) {
                int leftNumber = Integer.parseInt(item);
                node.setLeftNode(new BBTreeNode(leftNumber));
                nodeQueue.add(node.getLeftNode());
            }

            if (index == parts.length) {
                break;
            }

            item = parts[index++];
            item = item.trim();
            if (!item.equals("null")) {
                int rightNumber = Integer.parseInt(item);
                node.setRightNode(new BBTreeNode(rightNumber));
                nodeQueue.add(node.getRightNode());
            }
        }
        return root;
    }

    public static String integerArrayListToString(List<Integer> nums, int length) {
        if (length == 0) {
            return "[]";
        }

        StringBuilder result = new StringBuilder();
        for (int index = 0; index < length; index++) {
            Integer number = nums.get(index);
            result.append(number).append(", ");
        }
        return "[" + result.substring(0, result.length() - 2) + "]";
    }

    public static String integerArrayListToString(List<Integer> nums) {
        return integerArrayListToString(nums, nums.size());
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            BBTreeNode root = stringToTreeNode(line);

            List<Integer> ret = new BBTreeFunction().inorderTraversal(root);

            String out = integerArrayListToString(ret);

            System.out.print(out);
        }

        //List<String> line = new ArrayList<>();
        //for (int i = 0; i < line.size(); i++) {
        //    BBTreeNode root = stringToTreeNode(line.get(i));
        //}


    }

}
