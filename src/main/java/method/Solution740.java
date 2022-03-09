package method;

/**
 * @author Qbss
 * @date 2022/3/9
 * @desc
 */
public class Solution740 {

    public static void main(String[] args) {
        int[] nums = new int[]{2, 2, 3, 3, 3, 4};
        deleteAndEarn(nums);
    }

    public static int deleteAndEarn(int[] nums) {
        int maxVal = 0;
        for (int val : nums) {
            maxVal = Math.max(maxVal, val);
        }
        int[] sum = new int[maxVal + 1];
        for (int val : nums) {
            sum[val] += val;
        }
        return rob(sum);
    }

    public static int rob(int[] nums) {
        int size = nums.length;
        int first = nums[0], second = Math.max(nums[0], nums[1]);
        for (int i = 2; i < size; i++) {
            int temp = second;
            second = Math.max(first + nums[i], second);
            first = temp;
        }
        return second;
    }


}
