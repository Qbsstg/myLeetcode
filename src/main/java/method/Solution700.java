package method;

import common.TreeNode;

public class Solution700 {

    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) {
            return null;
        }
        TreeNode node = root;
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
