package method;

import java.util.Arrays;

/**
 * @author: Qbss
 * @date: 2025/1/14
 * @desc:
 */
public class Solution3065 {

    public int minOperations(int[] nums, int k) {
        return (int)Arrays.stream(nums).filter(x->x<k).count();
    }

}
