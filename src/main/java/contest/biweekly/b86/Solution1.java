package contest.biweekly.b86;

import java.util.HashSet;
import java.util.Set;

public class Solution1 {


    public boolean findSubarrays(int[] nums) {

        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (i + 1 < nums.length) {
                if (!set.add(nums[i] + nums[i + 1])) {
                    return true;
                }
            }
        }
        return false;

    }

}
