package method;

import java.util.Arrays;

public class Solution238 {

    public static int[] productExceptSelf(int[] nums) {

        int length = nums.length;
        int[] nums1 = new int[length];
        int[] nums2 = new int[length];

        for (int i = 0; i < length; i++) {
            if (i == 0) {
                nums1[i] = 1;
                nums2[length - 1] = 1;
            } else {
                nums1[i] = nums1[i - 1] * nums[i - 1];
                nums2[length - i - 1] = nums2[length - i] * nums[length - i];
            }
        }

        int[] result = new int[length];

        for (int i = 0; i < length; i++) {
            result[i] = nums1[i] * nums2[i];
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        System.out.println(Arrays.toString(productExceptSelf(nums)));
    }


}
