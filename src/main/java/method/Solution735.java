package method;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author Qbss
 * @date 2022/7/13
 * @desc
 */
public class Solution735 {

    public static void main(String[] args) {
        int[] asteroids = {-2, -1, 1, 2};
        System.out.println(Arrays.toString(asteroidCollision(asteroids)));
    }

    public static int[] asteroidCollision(int[] asteroids) {

        Stack<Integer> ans = new Stack<>();
        for (int asteroid : asteroids) {
            if (asteroid > 0) {
                ans.add(asteroid);
            } else if (asteroid < 0) {
                while (true) {
                    if (ans.isEmpty()) {
                        ans.add(asteroid);
                        break;
                    } else {
                        Integer peek = ans.peek();
                        if (peek < 0) {
                            ans.add(asteroid);
                            break;
                        }
                        if (peek > -asteroid) {
                            break;
                        } else if (peek == -asteroid) {
                            ans.pop();
                            break;
                        } else {
                            ans.pop();
                        }
                    }
                }
            } else {
                return null;
            }

        }
        //stack to list
        int[] ansList = new int[ans.size()];
        for (int i = ans.size() - 1; i >= 0; i--) {
            ansList[i] = ans.pop();
        }
        return ansList;

    }

}
