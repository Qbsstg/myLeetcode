package test;

import common.TreeNode;
import method.Solution117;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Qbss
 * @date 2022/7/25
 * @desc
 */
public class NodeTestService {


    public static TreeNode stringToNode(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
            return null;
        }

        String[] parts = input.split(",");
        String item = parts[0];
        TreeNode root = new TreeNode(Integer.parseInt(item));
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.add(root);

        int index = 1;
        while (!nodeQueue.isEmpty()) {
            TreeNode node = nodeQueue.remove();

            if (index == parts.length) {
                break;
            }

            item = parts[index++];
            item = item.trim();
            if (!item.equals("null")) {
                int leftNumber = Integer.parseInt(item);
                node.left = new TreeNode(leftNumber);
                nodeQueue.add(node.left);
            }

            if (index == parts.length) {
                break;
            }

            item = parts[index++];
            item = item.trim();
            if (!item.equals("null")) {
                int rightNumber = Integer.parseInt(item);
                node.right = new TreeNode(rightNumber);
                nodeQueue.add(node.right);
            }
        }
        return root;
    }

    public static String NodeToString(TreeNode root) {
        if (root == null) {
            return "[]";
        }

        String output = "";
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.add(root);
        while (!nodeQueue.isEmpty()) {
            TreeNode node = nodeQueue.remove();

            if (node == null) {
                output += "null, ";
                continue;
            }

            output += node.val + ", ";
            nodeQueue.add(node.left);
            nodeQueue.add(node.right);
        }
        return "[" + output.substring(0, output.length() - 2) + "]";
    }

    public static void main(String[] args) throws IOException {
        //BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        //String line;
        //while ((line = in.readLine()) != null) {

        String line = "[1,5,3,null,4,10,6,9,2]";
        String line1 = "[1,2,null,3,null,4,null,5]";
        String line2 = "[1,null,2,3,4,null,5]";
        String line3 = "[1,3,2,5,null,null,9,6,null,7]";
        String line5 = "[5,4,5,1,1,5]";
        String line6 = "[1,null,1,1,1,1,1,1]";
        String line7 = "[1,2,3,4,5,null,7]";
        TreeNode root = stringToNode(line7);

        System.out.println(new Solution117().connect(root));

        //System.out.println(NodeToString(new Solution998().insertIntoMaxTree(root, 3)));


        //}
    }

}
