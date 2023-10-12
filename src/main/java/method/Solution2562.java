package method;

/**
 * @author: Qbss
 * @date: 2023/10/12
 * @desc:
 */
public class Solution2562 {

    public static long findTheArrayConcVal(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int end = nums.length - 1;
        int start = 0;

        long count = 0;

        while (start < end) {

            count += Long.parseLong(nums[start] + String.valueOf(nums[end]));

            start++;
            end--;
        }

        if (start == end) {
            count += nums[start];
        }

        return count;

    }

    public static void main(String[] args) {
        int[] nums = {5, 14, 13, 8, 1};
    }
}
