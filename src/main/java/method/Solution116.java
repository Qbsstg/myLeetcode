package method;

import common.Node;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution116 {

    public Node connect(Node root) {

        if (root == null){
            return new Node();
        }
        List<Node> list = new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            Node poll = queue.poll();
            list.add(poll);
            if (poll.left != null && poll.right != null) {
                queue.offer(poll.left);
                queue.offer(poll.right);
            }
        }

        int start = 0;
        for (int i = 1; i < list.size() && start < list.size(); i++) {
            start = (int) Math.pow(2.0, i) - 1;
            int j = (int) Math.pow(2.0, i);
            if (j + start - 1 >= list.size()) {
                break;
            }
            Node node = null;
            while (j > 0) {
                Node node1 = list.get(j + start - 1);
                node1.next = node;
                node = node1;
                j--;
            }
        }
        return root;
    }

    public static Node stringToNode(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
            return null;
        }

        String[] parts = input.split(",");
        String item = parts[0];
        Node root = new Node(Integer.parseInt(item));
        Queue<Node> nodeQueue = new LinkedList<>();
        nodeQueue.add(root);

        int index = 1;
        while (!nodeQueue.isEmpty()) {
            Node node = nodeQueue.remove();

            if (index == parts.length) {
                break;
            }

            item = parts[index++];
            item = item.trim();
            if (!item.equals("null")) {
                int leftNumber = Integer.parseInt(item);
                node.left = new Node(leftNumber);
                nodeQueue.add(node.left);
            }

            if (index == parts.length) {
                break;
            }

            item = parts[index++];
            item = item.trim();
            if (!item.equals("null")) {
                int rightNumber = Integer.parseInt(item);
                node.right = new Node(rightNumber);
                nodeQueue.add(node.right);
            }
        }
        return root;
    }

    public static String NodeToString(Node root) {
        if (root == null) {
            return "[]";
        }

        String output = "";
        Queue<Node> nodeQueue = new LinkedList<>();
        nodeQueue.add(root);
        while (!nodeQueue.isEmpty()) {
            Node node = nodeQueue.remove();

            if (node == null) {
                output += "null, ";
                continue;
            }

            output += String.valueOf(node.val) + ", ";
            nodeQueue.add(node.left);
            nodeQueue.add(node.right);
        }
        return "[" + output.substring(0, output.length() - 2) + "]";
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            Node root = stringToNode(line);

            Node ret = new Solution116().connect(root);

            String out = NodeToString(ret);

            System.out.print(out);
        }
    }

}
