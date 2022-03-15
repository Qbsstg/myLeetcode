package method;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Qbss
 * @date 2022/3/15
 * @desc
 */
public class Solution2044 {


    public static void main(String[] args) {
        int[] nums1 = {3, 1};
        int[] nums2 = {2, 2, 2};
        int[] nums3 = {3, 2, 1, 5};
        //int[] ints1 = Arrays.copyOf(nums3, nums3.length + 1);
        System.out.println(countMaxOrSubsets(nums1));
    }

    public static int countMaxOrSubsets(int[] nums) {

        int total = nums[0];
        for (int num : nums) {
            total = total | num;
        }

        List<int[]> collect = new ArrayList<>();
        for (int num : nums) {
            dealDepth(collect, num);
        }

        int count = 0;
        for (int i = 0; i < collect.size(); i++) {

            int[] ints = collect.get(i);
            int sum = ints[0];

            for (int anInt : ints) {
                sum = sum | anInt;
            }
            if (sum == total) {
                count++;
            }
        }

        return count;
    }

    private static void dealDepth(List<int[]> collect, int a) {
        int[] c = {a};
        List<int[]> result = new ArrayList<>();

        for (int[] ints : collect) {
            int[] ints1 = Arrays.copyOf(ints, ints.length + 1);
            ints1[ints1.length - 1] = a;
            result.add(ints1);
        }

        result.add(c);

        collect.addAll(result);
    }

}
