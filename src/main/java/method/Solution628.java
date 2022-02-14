package method;

import java.util.Arrays;

/**
 * @author Qbss
 * @date 2021/4/12
 * @desc
 */
public class Solution628 {

    public static void main(String[] args) {
        int[] nums = new int[]{3, 4, 0, 0,-1, -5};
        System.out.println(maximumProduct(nums));
    }

    public static int maximumProduct(int[] nums) {
        int l = nums.length;
        Arrays.sort(nums);
        int[] result = new int[]{
                nums[0] * nums[1] * nums[2],
                nums[0] * nums[l - 1] * nums[l - 2],
                nums[0] * nums[1] * nums[l - 1],
                nums[l - 1] * nums[l - 2] * nums[l - 3]
        };
        return Arrays.stream(result).max().getAsInt();
    }

}
