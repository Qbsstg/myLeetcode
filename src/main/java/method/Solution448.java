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


}
