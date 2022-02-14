package method;

/**
 * @author Qbss
 * @date 2022/2/14
 * @desc
 */
public class Solution540 {


    public static void main(String[] args) {
        //int[] nums = {1, 1, 2, 3, 3, 4, 4, 8, 8};
        //int[] nums = {3,3,7,7,10,11,11};
        int[] nums = {0, 0, 1};
        System.out.println(singleNonDuplicate(nums));
    }


    public static int singleNonDuplicate(int[] nums) {

        int a = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == a) {
                a = -1;
            } else {
                if (a != -1) {
                    break;
                } else {
                    a = nums[i];
                }

            }
        }
        return a;


    }

}
