package method;

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

        int sum = 0;
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();


        for (int num : nums) {

            sum += num;
            int sumJ = sum - target;
            if (map.containsKey(sumJ)) {
                count = count + map.get(sumJ);
            }
            if (sum == target) {
                count++;
            }
            if (map.containsKey(sum)) {
                map.put(sum, map.get(sum) + 1);
            } else {
                map.put(sum, 1);
            }
        }
        return count;


    }

}
