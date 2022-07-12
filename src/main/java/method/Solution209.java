package method;

import java.time.OffsetDateTime;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Qbss
 * @date 2022/7/11
 * @desc
 */
public class Solution209 {

    /*
     * sum[i-1] + num[i] = sum[i]
     * sum[i] - sum[j-1] = interSum[i,j]
     * 区间和
     * sum[i] - sum[j-1] = k
     *
     * sum[i] - k = sum[j]
     * */
    public int minSubArrayLen(int target, int[] nums) {

        int count = 0;
        int sum = 0;
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {

            sum += nums[i];
            int sumJ = sum - target;
            if (map.containsKey(sumJ)) {
                count = count == 0 ? map.get(sumJ) : Math.min(count, map.get(sumJ));
            }
            if (sum == target) {
                count = count == 0 ? i + 1 : Math.min(count, i + 1);
            }
            if (map.containsKey(sum)) {
                Integer integer = map.get(sum);
                if (i + 1 < integer) {
                    map.put(sum, i + 1);
                }
            } else {
                map.put(sum, i + 1);
            }

        }
        return count;

    }

}
