package method;

import common.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Qbss
 * @date 2022/8/5
 * @desc
 */
public class Solution623 {

    public TreeNode addOneRow(TreeNode root, int val, int depth) {

        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.offer(root);

        if (depth == 1) {
            TreeNode node = new TreeNode(val);
            node.left = root;
            return node;
        }

        while (!deque.isEmpty()) {
            int size = deque.size();
            depth--;
            if (depth == 1) {
                for (int i = 0; i < size; i++) {
                    TreeNode poll = deque.poll();
                    if (poll.left != null) {
                        TreeNode node = new TreeNode(val);
                        node.left = poll.left;
                        poll.left = node;
                    } else {
                        TreeNode node = new TreeNode(val);
                        poll.left = node;
                    }
                    if (poll.right != null) {
                        TreeNode node = new TreeNode(val);
                        node.right = poll.right;
                        poll.right = node;
                    } else {
                        TreeNode node = new TreeNode(val);
                        poll.right = node;
                    }
                }
                break;
            } else {
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
        }

        return root;
    }

}
