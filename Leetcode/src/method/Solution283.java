package method;

import java.util.Arrays;

/**
 * @author Qbss
 * @date 2021/3/29
 * @desc
 */
public class Solution283 {

    public static void main(String[] args) {
        int[] nums = new int[]{1};
        moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }


    public static void moveZeroes(int[] nums) {

        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            int a = nums[i];
            if (a == 0) {
                k++;
            } else {
                if (k != 0){
                    nums[i - k] = nums[i];
                    nums[i] = 0;
                }
            }
        }

    }

}
