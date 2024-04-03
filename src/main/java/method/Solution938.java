package method;

import common.TreeNode;

/**
 * @author: Qbss
 * @date: 2024/2/26
 * @desc: 938. 二叉搜索树的范围和
 */
public class Solution938 {

    public int rangeSumBST(TreeNode root, int low, int high) {

        int result = 0;

        return result + dfs(root, low, high);

    }

    private int dfs(TreeNode node, int low, int high) {
        if (node == null) {
            return 0;
        }

        if (node.val >= low && node.val <= high) {
            return node.val + dfs(node.left, low, high) + dfs(node.right, low, high);
        }

        return dfs(node.left, low, high) + dfs(node.right, low, high);

    }

}
