package method;

import java.util.Arrays;

/**
 * @author: Qbss
 * @date: 2024/7/8
 * @desc:
 */
public class Solution724 {

    public static void main(String[] args) {
        int[] nums = {-1, -1, -1, -1, -1, -1};
        int[] nums1 = {1, 7, 3, 6, 5, 6};
        System.out.println(pivotIndex(nums));
        System.out.println(pivotIndex(nums1));
    }

    public static int pivotIndex(int[] nums) {
        int leftSum = 0;
        int rightSum = Arrays.stream(nums).sum();
        for (int i = 0; i < nums.length; i++) {
            leftSum += (i - 1 >= 0 ? nums[i-1] : 0);
            rightSum -= nums[i];
            if (leftSum == rightSum) {
                return i;
            }
        }
        return -1;
    }
}
