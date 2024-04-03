package method;

import common.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution235 {


    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        int pValue = p.val;
        int qValue = q.val;

        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.offer(root);
        while (!deque.isEmpty()) {
            TreeNode poll = deque.poll();
            if (poll != null) {
                if (pValue > poll.val) {
                    if (qValue > poll.val) {
                        deque.offer(poll.right);
                    } else if (qValue == poll.val) {
                        return poll;
                    } else {
                        return poll;
                    }
                } else if (pValue == poll.val) {
                    if (qValue > poll.val) {
                        return poll;
                    } else if (qValue == poll.val) {
                        return poll;
                    } else {
                        return poll;
                    }
                } else {
                    if (qValue > poll.val) {
                        return poll;
                    } else if (qValue < poll.val) {
                        deque.offer(poll.left);
                    } else {
                        return poll;
                    }
                }
            }
        }
        return root;
    }

}
