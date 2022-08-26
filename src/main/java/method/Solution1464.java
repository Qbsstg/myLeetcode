package method;

import java.util.Arrays;

/**
 * @author Qbss
 * @date 2022/8/26
 * @desc
 */
public class Solution1464 {

    public int maxProduct(int[] nums) {

        Arrays.sort(nums);
        return Math.max((nums[nums.length - 1] - 1) * (nums[nums.length - 2] - 1), (nums[0] - 1) + (nums[1] - 1));

    }

    private void sort(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            boolean flag = true;
            for (int j = nums.length - 1; j >= 0; j--) {
                if (nums[i] > nums[j]) {
                    int num = nums[i];
                    nums[i] = nums[j];
                    nums[j] = num;
                    flag = false;
                }
            }
            if (flag) {
                return;
            }
        }
    }

    private int bSerach(int[] nums, int k) {
        int start = 0;
        int end = nums.length - 1;



        while (start <= end) {
            int mid = (start + end) >> 1;
            if (nums[mid] < k) {
                start = mid + 1;
            } else if (nums[mid] > k) {
                end = end - 1;
            } else {
                return mid;
            }
        }
        return -(start + 1);
    }

}
