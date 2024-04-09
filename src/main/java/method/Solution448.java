package method;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Qbss
 * @date 2021/3/30
 * @desc
 */
public class Solution448 {

    public static void main(String[] args) {
        int[] nums = new int[]{4, 3, 2, 7, 8, 2, 3, 1};
        System.out.println(findDisappearedNumbers(nums));
    }


    public static List<Integer> findDisappearedNumbers(int[] nums) {


        //原地修改数组
        for (int i = 0; i < nums.length; i++) {
            int a = nums[i];
            if (a < 0) {
                a = -a;
            }
            int j = a - 1;
            if (nums[j] > 0) {
                nums[j] = -nums[j];
            }
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int a = nums[i];
            if (a > 0) {
                list.add(i + 1);
            }
        }
        return list;

    }

    public static List<Integer> findDisappearedNumbers1(int[] nums) {

        int length = nums.length;
        int[] ans = new int[length + 1];

        for (int num : nums) {
            if (ans[num] == 0) {
                ans[num] = 1;
            }
        }

        List<Integer> result = new ArrayList<>();
        for (int i = 1; i < ans.length; i++) {
            if (ans[i] == 0) {
                result.add(i);
            }
        }
        return result;
    }


}
