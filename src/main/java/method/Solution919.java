package method;

import common.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author Qbss
 * @date 2022/7/25
 * @desc
 */
public class Solution919 {

    public TreeNode test(TreeNode node) {
        CBTInserter cbtInserter = new CBTInserter(node);
        System.out.println(cbtInserter.insert(3));
        System.out.println(cbtInserter.insert(4));
        return cbtInserter.get_root();
    }


    static class CBTInserter {

        private TreeNode root;

        public CBTInserter(TreeNode root) {
            this.root = root;
        }

        public int insert(int val) {

            Deque<TreeNode> deque = new ArrayDeque<>();
            deque.offer(this.root);
            List<TreeNode> nodeList = new ArrayList<>();
            nodeList.add(new TreeNode(0));
            nodeList.add(this.root);

            while (!deque.isEmpty()) {
                TreeNode poll = deque.poll();
                if (poll.left != null) {
                    deque.offer(poll.left);
                    nodeList.add(poll.left);
                }
                if (poll.right != null) {
                    deque.offer(poll.right);
                    nodeList.add(poll.right);
                }
            }
            //当list长度为1时
            int size = nodeList.size();
            if (size == 2) {
                this.root.left = new TreeNode(val);
                return this.root.val;
            }

            if (size > 2) {
                size = size - 1;
                if (size % 2 == 0) {
                    int i = size / 2;
                    TreeNode node = nodeList.get(i);
                    node.right = new TreeNode(val);
                    return node.val;
                } else {
                    int i = (size + 1) / 2;
                    TreeNode node = nodeList.get(i);
                    node.left = new TreeNode(val);
                    return node.val;
                }
            }

            return -1;

        }

        public TreeNode get_root() {
            return root;
        }
    }

}
