package method;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Qbss
 * @date 2022/8/9
 * @desc
 */
public class Solution20 {

    public static void main(String[] args) {
        isValid("(");
    }

    public static boolean isValid(String s) {

        String[] split = s.split("");
        Deque<String> deque = new ArrayDeque<>();

        for (String s1 : split) {
            if ("(,{,[".contains(s1)) {
                deque.offer(s1);
            } else {
                String peek = deque.peekLast();
                if (deque.isEmpty()) {
                    return false;
                } else {
                    boolean temp = switch (peek) {
                        case "(" -> ")".equals(s1);
                        case "[" -> "]".equals(s1);
                        case "{" -> "}".equals(s1);
                        default -> false;
                    };
                    if (!temp) {
                        return false;
                    } else {
                        deque.pollLast();
                    }
                }
            }

        }
        return deque.isEmpty();
    }


}
