package method;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Qbss
 * @date 2022/10/9
 * @desc
 */
public class Solution856 {

    public static void main(String[] args) {
        scoreOfParentheses("()(()())");
    }


    public static int scoreOfParentheses(String s) {

        char[] chars = s.toCharArray();
        Deque<Integer> deque = new ArrayDeque<>();
        deque.offer(0);

        for (int i = 0; i < chars.length; i++) {
            char aChar = chars[i];
            if (aChar == ')') {

                Integer pollLast = deque.pollLast();
                deque.offer(deque.pollLast() + Math.max(pollLast * 2, 1));

            } else {
                deque.offer(0);
            }
        }
        return deque.peekFirst();
    }


}
