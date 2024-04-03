package method;

import common.TreeNode;

import java.util.*;
import java.util.stream.Collectors;

public class Solution653 {

    public boolean findTarget(TreeNode root, int k) {

        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.offer(root);
        List<Integer> list = new ArrayList<>();
        while (!deque.isEmpty()) {
            TreeNode poll = deque.poll();
            if (poll != null) {
                list.add(poll.val);
                if (poll.left != null) {
                    deque.offer(poll.left);
                }
                if (poll.right != null) {
                    deque.offer(poll.right);
                }
            }
        }
        Set<Integer> set = new HashSet<>(list);
        List<Integer> collect = list.stream().sorted().collect(Collectors.toList());
        for (Integer integer : collect) {

            if (set.contains(k - integer)&&k-integer != integer) {
                return true;
            }
        }
        return false;

    }

}
