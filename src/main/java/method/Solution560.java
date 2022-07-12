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

}
