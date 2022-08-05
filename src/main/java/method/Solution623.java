package method;

import common.Node;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Qbss
 * @date 2022/8/5
 * @desc
 */
public class Solution623 {

    public Node addOneRow(Node root, int val, int depth) {

        Deque<Node> deque = new ArrayDeque<>();
        deque.offer(root);

        if (depth == 1) {
            Node node = new Node(val);
            node.left = root;
            return node;
        }

        while (!deque.isEmpty()) {
            int size = deque.size();
            depth--;
            if (depth == 1) {
                for (int i = 0; i < size; i++) {
                    Node poll = deque.poll();
                    if (poll.left != null) {
                        Node node = new Node(val);
                        node.left = poll.left;
                        poll.left = node;
                    } else {
                        Node node = new Node(val);
                        poll.left = node;
                    }
                    if (poll.right != null) {
                        Node node = new Node(val);
                        node.right = poll.right;
                        poll.right = node;
                    } else {
                        Node node = new Node(val);
                        poll.right = node;
                    }
                }
                break;
            } else {
                for (int i = 0; i < size; i++) {
                    Node poll = deque.poll();
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
