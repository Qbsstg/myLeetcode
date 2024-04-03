package method;

import common.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Qbss
 * @date 2022/8/11
 * @desc
 */
public class Solution104 {


    public int maxDepth(TreeNode root) {
        return count(root);
    }

    private int count(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            return Math.max(count(root.left), count(root.right)) + 1;
        }
    }

    private int count(TreeNode root, int test) {

        if (root == null) {
            return 0;
        }

        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.offer(root);
        int count = 0;
        while (!deque.isEmpty()) {
            int size = deque.size();
            count++;
            for (int i = 0; i < size; i++) {
                TreeNode poll = deque.poll();
                if (poll.left != null) {
                    deque.offer(poll.left);
                }
                if (poll.right != null) {
                    deque.offer(poll.right);
                }
            }
        }
        return count;
    }

}
