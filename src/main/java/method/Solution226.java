package method;

import common.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Qbss
 * @date 2022/8/12
 * @desc
 */
public class Solution226 {

    public TreeNode invertTree(TreeNode root) {

        if (root == null) {
            return null;
        }

        if (root.left == null && root.right == null) {
            return root;
        }

        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.offer(root);
        while (!deque.isEmpty()) {
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                TreeNode poll = deque.poll();

                TreeNode left = poll.left;
                poll.left = poll.right;
                poll.right = left;

                if (poll.left != null) {
                    deque.offer(poll.left);
                }
                if (poll.right != null) {
                    deque.offer(poll.right);
                }
            }
        }
        return root;
    }


}
