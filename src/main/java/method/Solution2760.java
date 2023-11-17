package method;

/**
 * @author: Qbss
 * @date: 2023/11/17
 * @desc:
 */
public class Solution2760 {


    public static int longestAlternatingSubarray(int[] nums, int threshold) {
        int last = 0;
        int count = 0;

        for (; last < nums.length; last++) {
            int a = nums[last];
            if (a <= threshold && a % 2 == 0) {
                int fast = last + 1;
                if (fast < nums.length) {
                    for (; fast < nums.length; fast++) {
                        if (nums[fast] > threshold || nums[fast] % 2 != (fast - last) % 2) {
                            count = Math.max(count, fast - last);
                            break;
                        }
                        if (fast == nums.length - 1) {
                            count = Math.max(count, fast - last + 1);
                        }
                    }
                } else {
                    count = Math.max(count, 1);
                }

            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums1 = {3, 2, 5, 4};
        int[] nums2 = {1, 2};
        int[] nums3 = {2, 3, 4, 5};
        int[] nums4 = {1};
        int threshold1 = 5;
        int threshold2 = 2;
        int threshold3 = 4;
        int threshold4 = 1;
        //3
        //System.out.println(longestAlternatingSubarray(nums1, threshold1));
        //1
        //System.out.println(longestAlternatingSubarray(nums2, threshold2));
        //3
        //System.out.println(longestAlternatingSubarray(nums3, threshold3));
        //1
        System.out.println(longestAlternatingSubarray(nums4, threshold4));

    }

}
