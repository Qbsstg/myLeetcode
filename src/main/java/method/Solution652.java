package method;

import common.TreeNode;

import java.util.*;

public class Solution652 {

    public static void main(String[] args) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("null");
        stringBuilder.append("null");
        System.out.println(stringBuilder);
    }

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        Map<String, TreeNode> stringIntegerHashMap = new HashMap<>();
        Set<TreeNode> res = new HashSet<>();

        if (root.left == null && root.right == null) {
            return new ArrayList<>();
        }

        Deque<TreeNode> deque = new LinkedList<>();
        if (root.left != null) {
            deque.offer(root.left);
        }
        if (root.right != null) {
            deque.offer(root.right);
        }

        while (!deque.isEmpty()) {
            TreeNode poll = deque.poll();
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

    private String NodeToString(TreeNode root) {

        StringBuilder res = new StringBuilder();
        if (root == null) {
            return res.toString();
        }

        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.offer(root);
        res.append(root.val);

        while (!deque.isEmpty()) {
            TreeNode poll = deque.poll();
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

    private Map<String, TreeNode> map = new HashMap<>();
    private Set<TreeNode> set = new HashSet<>();

    private String dfs(TreeNode root) {
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


    private Set<TreeNode> repeat = new HashSet<>();
    int idx = 0;


}
