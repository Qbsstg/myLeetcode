package method;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Qbss
 * @date 2022/8/31
 * @desc
 */
public class Solution946 {

    public static void main(String[] args) {
        System.out.println(validateStackSequences(new int[]{1, 2, 3, 4, 5}, new int[]{4, 5, 3, 2, 1}));
        System.out.println(validateStackSequences(new int[]{1, 2, 3, 4, 5}, new int[]{4, 3, 5, 1, 2}));
    }


    public static boolean validateStackSequences(int[] pushed, int[] popped) {

        Deque<Integer> deque = new ArrayDeque<>();
        int a = 0;
        int b = 0;
        int length = pushed.length;

        while (true) {
            if (a < length) {
                if (deque.isEmpty()) {
                    deque.offer(pushed[a]);
                    a++;
                } else {
                    Integer peekLast = deque.peekLast();
                    if (peekLast == popped[b]) {
                        deque.pollLast();
                        b++;
                    } else {
                        deque.offer(pushed[a]);
                        a++;
                    }
                }
            } else {
                if (deque.isEmpty()) {
                    return true;
                } else {
                    Integer peekLast = deque.peekLast();
                    if (peekLast == popped[b]) {
                        deque.pollLast();
                        b++;
                    } else {
                        return false;
                    }
                }
            }
        }
    }

}
