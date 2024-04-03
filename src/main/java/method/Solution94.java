package method;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Qbss
 * @date 2022/8/10
 * @desc
 */
public class Solution94 {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        deal(root, list);
        return list;
    }

    private void deal(TreeNode root, List<Integer> list) {
        if (root != null) {
            deal(root.left, list);
            list.add(root.val);
            deal(root.right, list);
        }
    }

}
