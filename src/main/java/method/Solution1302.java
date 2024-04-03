package method;

import common.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Qbss
 * @date 2022/8/17
 * @desc
 */
public class Solution1302 {

    public int deepestLeavesSum(TreeNode root) {

        if (root == null) {
            return 0;
        }

        int res = 0;
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.offer(root);

        while (!deque.isEmpty()) {

            int size = deque.size();
            int count = 0;
            for (int i = 0; i < size; i++) {
                TreeNode poll = deque.poll();
                if (poll != null) {
                    count += poll.val;
                    if (poll.left != null) {
                        deque.offer(poll.left);
                    }
                    if (poll.right != null) {
                        deque.offer(poll.right);
                    }
                }
            }
            res = count;
        }
        return res;
    }

}
