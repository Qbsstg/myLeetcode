package method;

import common.TreeNode;

/**
 * @author Qbss
 * @date 2022/11/15
 * @desc
 */
public class Solution222 {


    public int countNodes(TreeNode root) {
        return dfs(root);
    }


    public int dfs(TreeNode node) {
        if (node == null) {
            return 0;
        } else {
            return dfs(node.left) + dfs(node.right) + 1;
        }

    }


}
