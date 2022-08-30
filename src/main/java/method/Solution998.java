package method;

import common.Node;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Qbss
 * @date 2022/8/30
 * @desc
 */
public class Solution998 {


    public Node insertIntoMaxTree(Node root, int val) {

        if (root == null) {
            return new Node(val);
        }

        if (root.val < val) {
            Node node = new Node(val);
            node.left = root;
            return node;
        }

        List<Integer> list = new ArrayList<>();
        dfs(list, root);
        list.add(val);

        return construct(list, 0, list.size() - 1);

    }

    public Node construct(List<Integer> list, int left, int right) {
        if (left > right) {
            return null;
        }
        int best = left;
        for (int i = left + 1; i <= right; ++i) {
            if (list.get(i) > list.get(best)) {
                best = i;
            }
        }
        Node node = new Node(list.get(best));
        node.left = construct(list, left, best - 1);
        node.right = construct(list, best + 1, right);
        return node;
    }

    private void dfs(List<Integer> list, Node node) {
        if (node != null) {
            dfs(list, node.left);
            list.add(node.val);
            dfs(list, node.right);

        }
    }

}
