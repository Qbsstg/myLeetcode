package method;

import common.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author: Qbss
 * @date: 2024/4/3
 * @desc: 1379. 找出克隆二叉树中的相同节点
 */
public class Solution1379 {

    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(cloned);

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode peek = queue.peek();
                if (peek != null) {
                    TreeNode poll = queue.poll();
                    if (target.val == poll.val) {
                        return poll;
                    }
                    if (poll.left != null) {
                        queue.add(poll.left);
                    }
                    if (poll.right != null) {
                        queue.add(poll.right);
                    }
                }
            }
        }
        return target;
    }
}
