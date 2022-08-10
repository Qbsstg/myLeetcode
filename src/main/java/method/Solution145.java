package method;

import common.Node;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Qbss
 * @date 2022/8/10
 * @desc
 */
public class Solution145 {


    public List<Integer> postorderTraversal(Node root) {
        List<Integer> list = new ArrayList<>();
        deal(root, list);
        return list;

    }

    private void deal(Node root, List<Integer> list) {
        if (root != null) {
            deal(root.left, list);
            deal(root.right, list);
            list.add(root.val);
        }
    }


}
