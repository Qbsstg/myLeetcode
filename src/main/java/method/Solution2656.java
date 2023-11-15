package method;

import java.util.Arrays;

/**
 * @author: Qbss
 * @date: 2023/11/15
 * @desc:
 */
public class Solution2656 {

    public int maximizeSum(int[] nums, int k) {
        Arrays.sort(nums);
        int max = nums[nums.length - 1];
        return (k * (max << 1 + k - 1)) >> 1;
    }

}
