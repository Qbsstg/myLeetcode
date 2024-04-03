package method;

import common.Node;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Qbss
 * @date 2022/3/10
 * @desc
 */
public class Solution589 {

    public static void main(String[] args) {

    }


    public List<Integer> preorder(Node root) {


        List<Integer> res = new ArrayList<>();

        helper(root, res);

        return res;

    }

    private static void helper(Node root, List<Integer> res) {

        if (root == null) {
            return;
        }

        res.add(root.val);

        for (int i = 0; i < root.children.size(); i++) {
            helper(root.children.get(i), res);
        }


    }


}
