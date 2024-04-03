package method;

import common.TreeNode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Qbss
 * @date 2022/8/12
 * @desc
 */
public class Solution112 {

    public void check(TreeNode root){
        System.out.println(hasPathSum(root, 0));
    }

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }

        Set<Integer> set = new HashSet<>();
        dfs(0, root, set);

        return set.contains(targetSum);
    }

    private void dfs(int count, TreeNode node, Set<Integer> ans) {
        if (node == null) {
            return;
        }

        count = count + node.val;

        if (node.left == null && node.right == null) {
            ans.add(count);
            return;
        }

        int left = count;
        int right = count;
        dfs(left, node.left, ans);
        dfs(right, node.right, ans);

    }


}
