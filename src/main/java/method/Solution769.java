package method;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution769 {

    public static void main(String[] args) {
        int[] arr = {4, 3, 2, 1, 0};
        System.out.println(maxChunksToSorted1(arr));
        System.out.println(maxChunksToSorted1(new int[]{2, 0, 1}));
    }

    public static int maxChunksToSorted(int[] arr) {

        int max = -1;
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(arr[i], max);
            if (max == i) {
                count++;
            }
        }
        return count;


    }

    public static int maxChunksToSorted1(int[] arr) {

        Deque<Integer> deque = new ArrayDeque<>();
        deque.offer(arr[0]);
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > deque.peekLast()) {
                deque.offer(arr[i]);
                continue;
            }

            Integer peekLast = deque.peekLast();
            while (!deque.isEmpty() && deque.peekLast() > arr[i]) {
                deque.pollLast();
            }
            deque.offer(peekLast);
        }
        return deque.size();
    }


}
