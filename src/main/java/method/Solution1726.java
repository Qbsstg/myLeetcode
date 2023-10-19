package method;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: Qbss
 * @date: 2023/10/19
 * @desc:
 */
public class Solution1726 {


    public static int tupleSameProduct(int[] nums) {

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                map.put(nums[i] * nums[j], map.getOrDefault(nums[i] * nums[j], 0) + 1);
            }
        }

        int sum = 0;
        for (Integer value : map.values()) {
            sum += (((value - 1) * value) / 2) * 8;
        }

        return sum;

    }

    public static void main(String[] args) {
        long i = 100000L * 100000;

        System.out.print(i);

    }
}
