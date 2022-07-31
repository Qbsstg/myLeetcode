package method;

import common.Node;

import java.util.ArrayDeque;
import java.util.Queue;

public class Solution1161 {

    public int maxLevelSum(Node root) {

        Queue<Node> queue = new ArrayDeque<>();
        queue.offer(root);

        int count = 0;
        int totalSum = root.val;
        int resCount = 1;

        while (!queue.isEmpty()) {
            int size = queue.size();
            count++;
            int sum = 0;
            for (int i = 0; i < size; i++) {
                Node poll = queue.poll();
                sum += poll.val;
                if (poll.left != null) {
                    queue.offer(poll.left);
                }
                if (poll.right != null) {
                    queue.offer(poll.right);
                }
            }
            if (totalSum < sum){
                totalSum = sum;
                resCount = count;
            }
        }
        return resCount;
    }

}
