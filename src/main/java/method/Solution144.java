package method;

import common.Node;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Qbss
 * @date 2022/8/10
 * @desc
 */
public class Solution144 {


    public List<Integer> preorderTraversal(Node root) {
        List<Integer> list = new ArrayList<>();
        deal(root, list);
        return list;
    }

    private void deal(Node root, List<Integer> list) {
        if (root != null) {
            list.add(root.val);
            deal(root.left, list);
            deal(root.right, list);
        }
    }


}
