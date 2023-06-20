package method;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Solution128 {


    public static int longestConsecutive(int[] nums) {
        Arrays.sort(nums);

        int count = 0;
        Deque<Integer> deque = new ArrayDeque<>();
        for (int num : nums) {
            if (deque.isEmpty()) {
                deque.addLast(num);
            } else {
                Integer peekLast = deque.peekLast();
                if (num - peekLast == 1) {
                    deque.addLast(num);
                } else if (num - peekLast > 1) {
                    count = Math.max(count,deque.size());
                    deque.clear();
                    deque.addLast(num);
                }
            }

        }

        return Math.max(deque.size(),count);
    }

    public static void main(String[] args) {
        System.out.println(longestConsecutive(new int[]{100,4,200,1,3,2}));
    }

}
