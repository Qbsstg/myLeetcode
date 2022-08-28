package contest.weekly.w308;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution2 {

    public static void main(String[] args) {
        removeStars("");
    }

    public static String removeStars(String s) {
        char[] chars = s.toCharArray();

        Deque<Character> deque = new ArrayDeque<>();
        for (int i = 0; i < chars.length; i++) {
            char aChar = chars[i];
            if (aChar != '*'){
                deque.offer(aChar);
            }else {
                if (!deque.isEmpty()){
                    deque.pollLast();
                }
            }
        }
        if (deque.isEmpty()){
            return "";
        }else {
            StringBuilder stringBuilder = new StringBuilder();
            while (!deque.isEmpty()){
                stringBuilder.append(deque.poll());
            }
            return stringBuilder.toString();
        }

    }

}
