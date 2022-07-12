package method;

import java.util.Arrays;

/**
 * @author Qbss
 * @date 2022/7/12
 * @desc
 */
public class Solution977 {


    public int[] sortedSquares(int[] nums) {

        for (int i = 0; i < nums.length; i++) {
            nums[i] = (int) Math.pow(nums[i], 2);
        }
        Arrays.sort(nums);
        return nums;
    }


    public int[] sortedSquares1(int[] nums) {

        int length = nums.length;
        int[] newNums = new int[length];

        int negative = -1;
        for (int i = 0; i < length; i++) {
            if (nums[i] < 0) {
                negative = i;
            } else {
                break;
            }
        }

        int index = 0;
        int i = negative;
        int j = negative + 1;

        while (i >= 0 || j < length) {
            if (i < 0) {
                newNums[index] = nums[j] * nums[j];
                j++;
            } else if (j == length) {
                newNums[index] = nums[i] * nums[i];
                i--;
            } else if (nums[i] * nums[i] < nums[j] * nums[j]) {
                newNums[index] = nums[i] * nums[i];
                i--;
            } else {
                newNums[index] = nums[j] * nums[j];
                j++;
            }
            index++;

        }

        return newNums;

    }

    public int[] sortedSquares2(int[] nums) {

        int length = nums.length;
        int[] newNums = new int[length];
        int index = length - 1;

        for (int i = 0, j = nums.length - 1; i < length && j >= i; ) {
            if (nums[j] * nums[j] > nums[i] * nums[i]) {
                newNums[index] = nums[j] * nums[j];
                j--;
            } else {
                newNums[index] = nums[i] * nums[i];
                i++;
            }
            index--;

        }

        return newNums;

    }


}
