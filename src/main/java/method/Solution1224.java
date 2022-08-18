package method;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Qbss
 * @date 2022/8/18
 * @desc
 */
public class Solution1224 {

    public int maxEqualFreq(int[] nums) {

        Map<Integer, Integer> count = new HashMap<>();
        Map<Integer, Integer> freq = new HashMap<>();

        int max = 0;
        int res = 0;

        for (int i = 0; i < nums.length; i++) {

            Integer orDefault = count.getOrDefault(nums[i], 0);

            if (orDefault > 0) {
                Integer orDefault1 = freq.get(orDefault);
                freq.put(orDefault, orDefault1 - 1);
            }

            int b = orDefault + 1;

            freq.put(b, freq.getOrDefault(b, 0) + 1);

            max = Math.max(max, b);
            count.put(nums[i], b);

            boolean ok = max == 1 ||
                    (freq.get(max) * max + freq.get(max - 1) * (max - 1) == i + 1 && freq.get(max) == 1) ||
                    (freq.get(max) * max == i && freq.get(1) == 1);
            if (ok) {
                res = Math.max(res, i + 1);
            }

        }

        return res;
    }

}
