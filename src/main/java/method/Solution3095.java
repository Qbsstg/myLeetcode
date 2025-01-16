package method;

/**
 * @author Qbss
 * @date 2025/1/16
 * @desc
 */
public class Solution3095 {

    public static int minimumSubarrayLength(int[] nums, int k) {

        int length = nums.length;
        if (length == 0) {
            return -1;
        }

        int slow = 0;

        if (length == 1) {
            return nums[slow] >= k ? 1 : -1;
        }

        int minValue = Integer.MAX_VALUE;

        for (; slow < nums.length; slow++) {
            int count = nums[slow];
            if (count >= k) {
                minValue = Math.min(1, minValue);
            } else {
                for (int fast = slow + 1; fast < length; fast++) {
                    int b = nums[fast];
                    count |= b;
                    if (count >= k) {
                        minValue = Math.min(fast - slow + 1, minValue);
                    }
                }
            }
        }
        return minValue == Integer.MAX_VALUE ? -1 : minValue;
    }

    public static void main(String[] args) {

        //System.out.println(2 | 1 | 8);

        System.out.println("3=" + minimumSubarrayLength(new int[]{2, 1, 8}, 10));
        System.out.println("1=" + minimumSubarrayLength(new int[]{1, 2}, 0));
        System.out.println("1=" + minimumSubarrayLength(new int[]{1, 2, 3}, 2));

    }
}
