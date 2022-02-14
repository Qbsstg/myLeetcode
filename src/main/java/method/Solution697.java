package method;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Qbss
 * @date 2021/4/27
 * @desc
 */
public class Solution697 {

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,2,3,1,4,2};
        System.out.println(findShortestSubArray(nums));

    }

    public static int findShortestSubArray(int[] nums) {

        HashMap<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {

            int a = nums[i];
            if (map.containsKey(a)) {
                map.get(a).add(i);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(a, list);
            }
        }

        int max = 0;

        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            List<Integer> value = entry.getValue();
            max = Math.max(value.size(), max);
        }

        int min = nums.length;

        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            List<Integer> value = entry.getValue();
            if (value.size() == max) {
                min = Math.min(min, value.get(value.size() - 1) - value.get(0) + 1);
            }
        }

        return min;
    }

}
