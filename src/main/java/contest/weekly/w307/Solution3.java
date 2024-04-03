package contest.weekly.w307;

import common.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution3 {

    public int amountOfTime(TreeNode root, int start) {

        if (root == null) {
            return 0;
        }

        Deque<TreeNode> deque = new ArrayDeque<>();

        if (root.val == start) {
            if (root.left == null && root.right == null) {
                return 0;
            }
            int depth = 0;
            deque.offer(root);
            while (!deque.isEmpty()) {
                int size = deque.size();
                depth++;
                for (int i = 0; i < size; i++) {
                    TreeNode poll = deque.poll();
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
            return depth - 1;
        } else {
            int leftDepth = 1;
            int rightDepth = 1;
            int index = 1;
            boolean rightTemp;
            if (root.left != null) {
                deque.offer(root.left);
                while (!deque.isEmpty()) {
                    int size = deque.size();
                    leftDepth++;
                    for (int i = 0; i < size; i++) {
                        TreeNode poll = deque.poll();
                        if (poll != null) {
                            if (poll.val == start) {
                                index = leftDepth;
                            }
                            if (poll.left != null) {
                                deque.offer(poll.left);
                            }
                            if (poll.right != null) {
                                deque.offer(poll.right);
                            }
                        }
                    }
                }
            }

            rightTemp = index == 1;

            if (root.right != null) {
                deque.offer(root.right);
                while (!deque.isEmpty()) {
                    int size = deque.size();
                    rightDepth++;
                    for (int i = 0; i < size; i++) {
                        TreeNode poll = deque.poll();
                        if (poll != null) {
                            if (poll.val == start) {
                                index = rightDepth;
                            }
                            if (poll.left != null) {
                                deque.offer(poll.left);
                            }
                            if (poll.right != null) {
                                deque.offer(poll.right);
                            }
                        }
                    }
                }
            }

            if (rightTemp) {
                return Math.max(leftDepth - 1 + index - 1, rightDepth - index);
            } else {
                return Math.max(leftDepth - index, rightDepth - 1 + index - 1);
            }
        }
    }
}
