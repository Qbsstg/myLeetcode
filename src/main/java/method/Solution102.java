package method;

import common.Node;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author Qbss
 * @date 2022/8/11
 * @desc
 */
public class Solution102 {

    public List<List<Integer>> levelOrder(Node root) {

        List<List<Integer>> res = new ArrayList<>();

        if (root == null) {
            return res;
        }
        Deque<Node> deque = new ArrayDeque<>();
        deque.offer(root);

        while (!deque.isEmpty()) {
            int size = deque.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                Node poll = deque.poll();
                if (poll != null) {
                    list.add(poll.val);
                    if (poll.left != null) {
                        deque.offer(poll.left);
                    }
                    if (poll.right != null) {
                        deque.offer(poll.right);
                    }
                }
            }
            res.add(list);
        }
        return res;
    }

}
