package method;

import common.Node;

public class Solution700 {

    public Node searchBST(Node root, int val) {
        if (root == null) {
            return null;
        }
        Node node = root;
        while (true) {
            if (node == null) {
                return node;
            }
            if (node.val == val) {
                return node;
            } else {
                if (node.val < val) {
                    node = node.right;
                } else {
                    node = node.left;
                }
            }
        }
    }


}
