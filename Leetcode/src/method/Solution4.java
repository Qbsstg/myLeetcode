package method;

import java.util.Arrays;

/**
 * @author Qbss
 * @date 2021/7/13
 * @desc
 */
public class Solution4 {

    public static void main(String[] args) {
        int[] nums1 = {2};
        int[] nums2 = {};
        int[] extracted = extracted(nums1, nums2);

        System.out.println(Arrays.toString(extracted));
    }


    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int l = nums1.length + nums2.length;

        if (l == 0){
            return 0;
        }
        //是偶数
        if (l % 2 == 0) {
            int i = l / 2;
            int[] extracted = extracted(nums1, nums2);
            return (extracted[i - 1] + extracted[i]) / 2.0;

        }
        //是奇数
        else {
            return extracted(nums1, nums2)[l / 2];
        }
    }

    private static int[] extracted(int[] nums1, int[] nums2) {
        int l = nums1.length + nums2.length;
        int[] nums = new int[l];
        int i = 0;
        int j = 0;

        while (i + j < l) {
            if (i < nums1.length && j < nums2.length) {
                if (nums2[j] >= nums1[i]) {
                    nums[i + j] = nums1[i];
                    i++;
                } else {
                    nums[i + j] = nums2[j];
                    j++;
                }
            } else if (i == nums1.length) {
                nums[i + j] = nums2[j];
                j++;
            } else if (j == nums2.length) {
                nums[i + j] = nums1[i];
                i++;
            }

        }

        return nums;
    }

}
