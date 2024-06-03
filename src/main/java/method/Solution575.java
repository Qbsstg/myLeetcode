package method;

import java.util.HashSet;
import java.util.Set;

/**
 * @author: Qbss
 * @date: 2024/6/3
 * @desc:
 */
public class Solution575 {

    public int distributeCandies(int[] candyType) {
        int l = candyType.length >> 1;
        Set<Integer> set = new HashSet<>();
        for (int c : candyType) {
            set.add(c);
        }
        return Math.min(set.size(), l);
    }

}
