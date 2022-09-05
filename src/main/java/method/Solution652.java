package method;

import common.Node;
import org.apache.commons.lang3.tuple.MutablePair;
import org.apache.commons.lang3.tuple.Pair;

import java.util.*;

public class Solution652 {

    public static void main(String[] args) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("null");
        stringBuilder.append("null");
        System.out.println(stringBuilder);
    }

    public List<Node> findDuplicateSubtrees(Node root) {
        Map<String, Node> stringIntegerHashMap = new HashMap<>();
        Set<Node> res = new HashSet<>();

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
                if (stringIntegerHashMap.containsKey(key)) {
                    res.add(poll);
                } else {
                    stringIntegerHashMap.put(key, poll);
                }
                deque.offer(poll.left);
                deque.offer(poll.right);
            }
        }
        return new ArrayList<>(set);
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

    private Map<String, Node> map = new HashMap<>();
    private Set<Node> set = new HashSet<>();

    private String dfs(Node root) {
        if (root == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(root.val);
        sb.append('(');
        sb.append(dfs(root.left));
        sb.append(')').append('(');
        sb.append(dfs(root.right));
        sb.append(')');

        if (map.containsKey(sb.toString())) {
            set.add(map.get(sb.toString()));
        } else {
            map.put(sb.toString(), root);
        }
        return sb.toString();
    }

    private Map<String, Pair<Node, Integer>> seen = new HashMap<>();
    private Set<Node> repeat = new HashSet<>();
    int idx = 0;

    public int dfsSeen(Node root) {
        if (root == null) {
            return 0;
        }
        int[] tri = {root.val, dfsSeen(root.left), dfsSeen(root.right)};
        String hash = Arrays.toString(tri);

        if (seen.containsKey(hash)) {
            repeat.add(seen.get(hash).getKey());
        } else {
            MutablePair<Node, Integer> pair = new MutablePair<>();
            pair.setLeft(root);
            pair.setRight(++idx);
            seen.put(hash, pair);
        }
        return idx;
    }


}
