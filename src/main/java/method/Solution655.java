package method;

import common.Node;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author Qbss
 * @date 2022/8/22
 * @desc
 */
public class Solution655 {


    private List<List<String>> res = new ArrayList<>();

    private int h;

    public List<List<String>> printTree(Node root) {

        Deque<Node> deque = new ArrayDeque<>();
        deque.offer(root);

        int depth = 0;

        while (!deque.isEmpty()) {
            depth++;
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                Node poll = deque.poll();
                if (poll != null) {
                    if (poll.left != null) {
                        deque.offer(poll.left);
                    }
                    if (poll.right != null) {
                        deque.offer(poll.right);
                    }
                }
            }
        }

        int m = depth;
        int n = (1 << depth) - 1;
        h = depth - 1;

        for (int i = 0; i < m; i++) {
            List<String> list = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                list.add("");
            }
            res.add(list);
        }

        dfs(root, 0, (n - 1) / 2);

        return res;
    }

    private void dfs(Node root, int r, int c) {
        if (root != null) {
            res.get(r).set(c, String.valueOf(root.val));
            if (root.left != null) {
                dfs(root.left, r + 1, c - (1 << (h - r - 1)));
            }
            if (root.right != null) {
                dfs(root.right, r + 1, c + (1 << (h - r - 1)));
            }
        }

    }


}
