package study.sort;

import java.util.Arrays;

/**
 * @author Qbss
 * @date 2022/7/29
 * @desc 冒泡排序
 */
public class BubbleSort {

    public static void main(String[] args) {
        BubbleSort sort = new BubbleSort();
        int[] nums = {3, 1, 4, 2, 5};
        sort.sort(nums);
        System.out.println(Arrays.toString(nums));

    }


    private void sort(int[] nums) {

        if (nums == null) {
            return;
        }
        int length = nums.length;
        if (length == 0 || length == 1) {
            return;
        }
        for (int l = length; l > 0; l--) {
            for (int i = 1; i < l; i++) {
                int now = nums[i];
                int pre = nums[i - 1];
                if (now < pre) {
                    nums[i] = pre;
                    nums[i - 1] = now;
                }
            }
        }

    }

}
