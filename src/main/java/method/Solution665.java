package method;

import java.util.Arrays;

/**
 * @author Qbss
 * @date 2021/4/15
 * @desc
 */
public class Solution665 {

    public static void main(String[] args) {
        int[] nums = new int[]{4, 4, 2, 3};
        System.out.println(checkPossibility(nums));
//        System.out.println(check(1, 3, 2));
    }

    public static boolean checkPossibility(int[] nums) {

        int length = nums.length;

        if (length <= 2) {
            return true;
        } else {
            if (nums[1] - nums[0] >= 0){

            }
        }
        return false;
    }

    private static boolean check(Integer a, Integer b, Integer c) {
        if (a != null && b != null && c != null) {
            if (b - a <= 0 && c - b >= 0) {
                return c > a + 1;
            } else {
                return true;
            }
        }
//        else if (a == null && b != null && c != null) {
////            if (c)
//        }
        else {
            return true;
        }
    }


}
