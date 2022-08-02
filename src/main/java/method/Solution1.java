package method;

import java.util.*;

public class Solution1 {


    public static int[] twoSum(int[] nums, int target) {
        int[] reNums = new int[2];
        for (int i = 0; i < nums.length; i++) {
            int a = nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                int b = nums[j];
                if (a + b == target) {
                    reNums[0] = i;
                    reNums[1] = j;
                    break;
                }
            }
        }
        return reNums;
    }

    public static int[] twoSum1(int[] nums, int target) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            List<Integer> orDefault = map.getOrDefault(nums[i], new ArrayList<>());
            orDefault.add(i);
            map.put(nums[i], orDefault);
        }

        for (Map.Entry<Integer, List<Integer>> next : map.entrySet()) {
            Integer key = next.getKey();
            int i = target - key;

            if (i == key) {
                List<Integer> value = next.getValue();
                if (value.size() > 1) {
                    return new int[]{value.get(0), value.get(1)};
                }
            } else {
                List<Integer> list = map.get(i);
                if (list != null) {
                    return new int[]{next.getValue().get(0), list.get(0)};
                }
            }
        }
        return new int[]{};
    }


    public static void main(String[] args) {
        int[] nums = {3, 3};
        int target = 6;
        int[] reNums = twoSum1(nums, target);


        System.out.println(Arrays.toString(reNums));
    }


}
