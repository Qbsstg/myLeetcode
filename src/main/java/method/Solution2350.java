package method;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Qbss
 * @date 2022/7/28
 * @desc
 */
public class Solution2350 {

    public static void main(String[] args) {
        int[] rolls = {4, 2, 1, 2, 3, 3, 2, 4, 1};
        int k = 4;
        System.out.println(shortestSequence(rolls, k));
    }


    public static int shortestSequence(int[] rolls, int k) {

        int ans = 1;
        Set<Integer> set = new HashSet<>();

        for (int roll : rolls) {
            set.add(roll);
            if (set.size() == k) {
                set.clear();
                ans++;
            }
        }
        return ans;
    }
}
