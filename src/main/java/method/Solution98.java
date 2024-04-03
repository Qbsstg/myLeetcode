package method;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution98 {


    public boolean isValidBST(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        deal(root, list);
        if (list.size() == 1) {
            return true;
        }
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) <= list.get(i - 1)) {
                return false;
            }
        }
        return true;
    }

    private void deal(TreeNode root, List<Integer> list) {
        if (root != null) {
            deal(root.left, list);
            list.add(root.val);
            deal(root.right, list);
        }
    }

}
