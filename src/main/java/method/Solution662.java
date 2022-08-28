package method;

import common.Node;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.stream.Collectors;

public class Solution662 {


    public int widthOfBinaryTree(Node root) {

        if (root == null) {
            return 0;
        }

        Deque<Node> deque = new ArrayDeque<>();
        deque.offer(root);

        if (root.left == null && root.right == null) {
            return 1;
        }

        List<List<Integer>> res = new ArrayList<>();
        while (!deque.isEmpty()) {
            int size = deque.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                Node poll = deque.poll();
                if (poll != null) {
                    if (poll.left != null) {
                        deque.offer(poll.left);
                        list.add(poll.left.val);
                    } else {
                        list.add(null);
                    }
                    if (poll.right != null) {
                        deque.offer(poll.right);
                        list.add(poll.right.val);
                    } else {
                        list.add(null);
                    }
                }
            }
            res.add(list);
        }

        List<Integer> collect = res.stream().map(x -> {
            int start = -1;
            int end = -1;
            for (int i = 0; i < x.size(); i++) {
                if (x.get(i) != null) {
                    if (start == -1) {
                        start = i;
                    }
                    end = i;
                }
            }
            return end - start + 1;
        }).collect(Collectors.toList());

        return collect.stream().reduce(Integer::max).get();
    }


}
