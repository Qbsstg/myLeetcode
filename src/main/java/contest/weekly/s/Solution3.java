package contest.weekly.s;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution3 {

    public static void main(String[] args) {
        robotWithString("bdda");
    }

    public static String robotWithString(String s) {

        char[] chars = s.toCharArray();
        Deque<Character> deque = new ArrayDeque<>();

        StringBuilder stb = new StringBuilder();

        for (int i = 0; i < chars.length; i++) {
            char aChar = chars[i];
            if (deque.isEmpty()) {
                deque.offer(aChar);
            } else {
                if (aChar >= deque.peekLast()) {
                    deque.offer(aChar);
                } else {
                    if (aChar <= deque.peekFirst()) {
                        stb.append(aChar);
                        while (!deque.isEmpty() && deque.peekFirst() >= aChar) {
                            stb.append(deque.pollFirst());
                        }
                    } else {
                        while (!deque.isEmpty() && deque.peekFirst() >= aChar) {
                            stb.append(deque.pollFirst());
                        }
                        deque.offerFirst(aChar);
                    }
                }
            }
        }

        while (!deque.isEmpty()){
            stb.append(deque.pollFirst());
        }

        return stb.toString();

    }

}
