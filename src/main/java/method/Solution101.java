package method;

import common.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author Qbss
 * @date 2022/8/11
 * @desc
 */
public class Solution101 {

    public boolean isSymmetric(TreeNode root) {

        if (root == null) {
            return true;
        }

        Deque<TreeNode> deque = new ArrayDeque<>();
        if (root.left != null&&root.right != null){
            deque.offer(root.left);
            deque.offer(root.right);
        }else return root.left == null && root.right == null;
        while (!deque.isEmpty()) {
            int size = deque.size();
            List<TreeNode> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode poll = deque.poll();
                if (poll.left != null) {
                    deque.offer(poll.left);
                }
                if (poll.right != null) {
                    deque.offer(poll.right);
                }
                list.add(poll);
            }
            if (size % 2 != 0) {
                return false;
            }
            for (int i = 0; i < size / 2; i++) {
                TreeNode left = list.get(i);
                TreeNode right = list.get(size - i - 1);
                if (left.val != right.val) {
                    return false;
                }
                if (left.left == null) {
                    if (right.right != null) {
                        return false;
                    }
                }
                if (left.right == null) {
                    if (right.left != null) {
                        return false;
                    }
                }
                if (right.left == null) {
                    if (left.right != null) {
                        return false;
                    }
                }
                if (right.right == null) {
                    if (left.left != null) {
                        return false;
                    }
                }
                if (left.left != null){
                    if (left.left.val != right.right.val){
                        return false;
                    }
                }
                if (left.right != null){
                    if (left.right.val != right.left.val){
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
