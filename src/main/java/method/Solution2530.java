package method;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

/**
 * @author: Qbss
 * @date: 2023/10/18
 * @desc:
 */
public class Solution2530 {

    public static long maxKelements(int[] nums, int k) {


        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        Arrays.stream(nums).forEach(queue::add);

        long sum = 0;

        for (int i = 1; i <= k; i++) {
            if (!queue.isEmpty()) {
                Integer poll = queue.poll();
                if (poll != null) {
                    sum += poll;
                    queue.add((int) Math.ceil(poll / 3.0));
                }
            }
        }

        return sum;


    }

    public static void main(String[] args) {
        int[] nums = {1, 10, 3, 3, 3};
        System.out.println(maxKelements(nums, 3));
    }

}
