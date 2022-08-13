package method;

import common.Node;

public class Solution701 {

    public Node insertIntoBST(Node root, int val) {
        if (root == null) {
            return new Node(val);
        }
        Node node = root;
        while (true) {
            if (val > node.val) {
                if (node.right == null) {
                    node.right = new Node(val);
                    break;
                } else {
                    node = node.right;
                }
            } else if (val < node.val) {
                if (node.left == null) {
                    node.left = new Node(val);
                    break;
                } else {
                    node = node.left;
                }
            } else {
                return root;
            }

        }
        return root;
    }


}
