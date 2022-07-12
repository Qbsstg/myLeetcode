package method;

import java.util.Arrays;

/**
 * @author Qbss
 * @date 2022/7/12
 * @desc
 */
public class Solution189 {


    public static void main(String[] args) {
        int[] nums = {-1, -100, 3, 99};
        int k = 2;
        rotate3(nums, k);
        System.out.println(Arrays.toString(nums));
    }

    public static void rotate(int[] nums, int k) {

        int length = nums.length;
        int[] ans = new int[length];

        for (int i = 0; i < nums.length; i++) {
            int index = (i + k) % length;
            ans[index] = nums[i];
        }
        System.arraycopy(ans, 0, nums, 0, length);
    }

    public static void rotate1(int[] nums, int k) {


        int length = nums.length;
        int count = 0;

        for (int i = 0; i < length; i++) {
            int temp = nums[i];
            int index = i;
            do {
                int targetIndex = (index + k) % length;
                int mid = nums[targetIndex];
                nums[targetIndex] = temp;
                temp = mid;
                index = targetIndex;
                count++;
            } while (i != index);
            if (count == length) {
                break;
            }
        }
    }

    public static void rotate3(int[] nums, int k) {

        int length = nums.length;
        k = k%length;

        reverse(nums, 0, length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, length - 1);

    }

    public static void reverse(int[] nums, int start, int end) {
        while (start < end ) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

}
