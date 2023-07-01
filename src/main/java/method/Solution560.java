package method;

import java.util.HashMap;
import java.util.Map;

public class Solution560 {


    public int subarraySum(int[] nums, int k) {

        int sum = 0;
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            sum += num;
            int sumJ = sum - k;
            if (map.containsKey(sumJ)) {
                count = count + map.get(sumJ);
            }
            if (sum == k) {
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


    public int subarraySum1(int[] nums, int k) {

        int count = 0;

        int[] preSum = new int[nums.length + 1];
        preSum[0] = 0;
        for (int i = 0; i < nums.length; i++) {
            preSum[i + 1] = preSum[i] + nums[i];
        }

        for (int i = 1; i < preSum.length; i++) {
            for (int j = 0; j < i; j++) {
                if (preSum[j] - preSum[i] == k) {
                    count++;
                }
            }
        }
        return count;
    }

    public int subarraySum2(int[] nums, int k) {

        int count = 0;
        int sum = 0;
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            sum += num;
            int sumj = sum - k;

            if (map.containsKey(sumj)) {
                count += map.get(sumj);
            }

            map.put(sum, map.getOrDefault(sum, 0) + 1);

        }

        return count;

    }

}
