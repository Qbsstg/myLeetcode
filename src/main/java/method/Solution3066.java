package method;

import java.util.PriorityQueue;

/*
 * @desc 3066. 超过阈值的最少操作数 II
 * */
public class Solution3066 {

    public static int minOperations(int[] nums, int k) {
        PriorityQueue<Long> queue = new PriorityQueue<>();
        for (int num : nums) {
            queue.add((long) num);
        }

        Long peek = queue.peek();
        int count = 0;
        while (peek != null && peek < k) {
            Long p1 = queue.poll();
            Long p2 = queue.poll();
            if (p1 != null && p2 != null) {
                Long pNew = (p1 << 1) + p2;
                queue.add(pNew);
                count++;
            }
            peek = queue.peek();
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = {2, 11, 10, 1, 3};
        int k = 10;

        System.out.println("2=" + minOperations(nums, k));
        System.out.println("4=" + minOperations(new int[]{2, 11, 10, 1, 3}, 20));
        System.out.println("2=" + minOperations(new int[]{1000000000, 999999999, 1000000000,
                999999999,
                1000000000, 999999999}, 1000000000));

    }

}
