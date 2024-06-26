package method;

import common.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * @author: Qbss
 * @date: 2023/11/3
 * @desc:
 */
public class Solution117 {

    public TreeNode connect(TreeNode root) {

        if (root == null) {
            return null;
        }

        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<TreeNode> list = new ArrayList<>(size);
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                if (poll != null) {
                    if (poll.left != null){
                        queue.add(poll.left);
                    }
                    if (poll.right != null){
                        queue.add(poll.right);
                    }
                    list.add(poll);
                }
            }
            for (int i = list.size() - 1; i >= 0; i--) {
                if (i == list.size() - 1) {
                    list.get(i).next = null;
                } else {
                    list.get(i).next = list.get(i+1);
                }
            }
        }
        return root;
    }

}
