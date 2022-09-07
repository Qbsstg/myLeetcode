package method;

import common.Node;

import java.util.*;

/**
 * @author Qbss
 * @date 2022/9/2
 * @desc
 */
public class Solution687 {

    public int longestUnivaluePath(Node root) {

        if (root == null||(root.left == null && root.right == null)) {
            return 0;
        }

        int res = 0;

        Deque<Node> deque = new ArrayDeque<>();
        deque.offer(root);
        while (!deque.isEmpty()) {
            Node poll = deque.poll();
            if (poll != null) {
                if (poll.val != 5555){
                    int leftCount = count(poll.left, poll.val);
                    int rightCount = count(poll.right, poll.val);
                    res = Math.max(leftCount + rightCount, res);
                    if (poll.left!= null){
                        deque.offer(poll.left);
                    }
                    if (poll.right != null){
                        deque.offer(poll.right);
                    }
                    poll.val = 5555;
                }
            }
        }

        return res;

    }


    private int count(Node node, int val) {
        if (node != null && node.val == val&&node.val != 5555) {
            node.val = 5555;
            return Math.max(count(node.left, val), count(node.right, val)) + 1;
        }
        return 0;
    }


}
