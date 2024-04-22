package method;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author: Qbss
 * @date: 2024/4/18
 * @desc: 2007. 从双倍数组中还原原数组
 */
public class Solution2007 {

    public static void main(String[] args) {
        Queue<Integer> queue = new PriorityQueue<>();
        queue.add(3);
        queue.add(1);
        queue.add(2);
        queue.add(2);
        queue.add(2);
        queue.remove(2);
        System.out.println(queue);
    }


    public int[] findOriginalArray(int[] changed) {
        int length = changed.length;
        if (length == 0 || length % 2 == 1) {
            return new int[]{};
        }

        Queue<Integer> queue = new PriorityQueue<>();
        for (int i : changed) {
            queue.add(i);
        }
        List<Integer> result = new ArrayList<>();
        while (!queue.isEmpty()) {
            Integer poll = queue.poll();
            if (queue.remove(poll << 1)) {
                result.add(poll);
            } else {
                return new int[]{};
            }
        }

        return result.stream().mapToInt(Integer::intValue).toArray();
    }

}
