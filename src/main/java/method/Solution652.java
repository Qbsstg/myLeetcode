package method;

import common.Node;

import java.util.*;

public class Solution652 {

    public static void main(String[] args) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("null");
        stringBuilder.append("null");
        System.out.println(stringBuilder);
    }

    public List<Node> findDuplicateSubtrees(Node root) {
        Map<String, Integer> stringIntegerHashMap = new HashMap<>();
        List<Node> res = new ArrayList<>();

        if (root.left == null && root.right == null) {
            return new ArrayList<>();
        }

        Deque<Node> deque = new LinkedList<>();
        if (root.left != null) {
            deque.offer(root.left);
        }
        if (root.right != null) {
            deque.offer(root.right);
        }

        while (!deque.isEmpty()) {
            Node poll = deque.poll();
            if (poll != null) {

                String key = NodeToString(poll);
                Integer integer = stringIntegerHashMap.get(key);
                if (integer == null) {
                    stringIntegerHashMap.put(key, 1);
                } else {
                    if (integer == 1) {
                        stringIntegerHashMap.put(key, 2);
                        res.add(poll);
                    }
                }
                deque.offer(poll.left);
                deque.offer(poll.right);
            }
        }
        return res;
    }

    private String NodeToString(Node root) {

        StringBuilder res = new StringBuilder();
        if (root == null) {
            return res.toString();
        }

        Deque<Node> deque = new ArrayDeque<>();
        deque.offer(root);
        res.append(root.val);

        while (!deque.isEmpty()) {
            Node poll = deque.poll();
            if (poll == null) {
                res.append("null,");
            } else {
                res.append(poll.val).append(",");
                if (poll.left != null) {
                    deque.offer(poll.left);
                }
                if (poll.right != null) {
                    deque.offer(poll.right);
                }
            }
        }
        return res.substring(0, res.length() - 1);
    }


}
