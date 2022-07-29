package method;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author Qbss
 * @date 2022/7/29
 * @desc
 */
public class Solution15 {

    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        int[] nums1 = {0, 0, 0};
        int[] nums2 = {1, 1, -2};
        int[] nums3 = {-1, 0, 1, 0};
        int[] nums5 = {-1, -1, 2};
        System.out.println(threeSum(nums));
        System.out.println(threeSum(nums1));
        System.out.println(threeSum(nums2));
        System.out.println(threeSum(nums3));
        System.out.println(threeSum(nums5));
    }

    public static List<List<Integer>> threeSum(int[] nums) {

        if (nums.length < 3) {
            return new ArrayList<>();
        }
        Arrays.sort(nums);
        int min = nums[0];
        int max = nums[nums.length - 1];
        if (min > 0 || max < 0) {
            return new ArrayList<>();
        }

        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            List<Integer> orDefault = map.getOrDefault(nums[i], new ArrayList<>());
            orDefault.add(i);
            map.put(nums[i], orDefault);
        }

        List<Integer> collect = Arrays.stream(nums).boxed().distinct().collect(Collectors.toList());

        List<List<Integer>> res = new ArrayList<>();

        for (int i = 0; i < collect.size(); i++) {
            Integer a = collect.get(i);
            if (a < 0) {
                int j = i;
                if (map.get(a).size() == 1) {
                    j = j + 1;
                }
                for (; j < collect.size(); j++) {
                    Integer b = collect.get(j);
                    int value = -a - b;
                    List<Integer> list = map.get(value);
                    if (list != null) {
                        if (value >= b) {
                            if (value == b) {
                                if (list.size() > 1) {
                                    res.add(Arrays.asList(a, b, value));
                                }
                            } else {
                                if (list.size() > 0) {
                                    res.add(Arrays.asList(a, b, value));
                                }
                            }
                        }
                    }
                }
            } else if (a == 0) {
                if (map.get(a).size() > 2) {
                    res.add(Arrays.asList(0, 0, 0));
                }
            }
        }
        return res;
    }


}
