package method;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Qbss
 * @date 2022/9/9
 * @desc
 */
public class Solution1598 {

    public static void main(String[] args) {
        System.out.println(minOperations(new String[]{"d1/", "d2/", "../", "d21/", "./"}));
    }

    public static int minOperations(String[] logs) {

        Deque<String> deque = new ArrayDeque<>();

        for (String log : logs) {
            switch (log){
                case "../":
                    if (!deque.isEmpty()){
                        deque.pollLast();
                    }
                    break;
                case "./":
                    break;
                default:
                    deque.offer(log);
                    break;
            }
        }
        return deque.size();
    }

}
